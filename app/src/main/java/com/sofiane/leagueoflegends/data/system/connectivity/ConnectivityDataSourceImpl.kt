package com.sofiane.leagueoflegends.data.system.connectivity

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkCapabilities.NET_CAPABILITY_INTERNET
import android.net.NetworkCapabilities.NET_CAPABILITY_VALIDATED
import android.net.NetworkCapabilities.TRANSPORT_WIFI
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import android.os.Build
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

/**
 * DataSource Android qui convertit les callbacks systèmes
 * en un Flow<NetworkState> pour l'UI.
 */
class ConnectivityDataSourceImpl @Inject constructor(
    private val connectivityManager: ConnectivityManager,
    private val wifiManager: WifiManager
) : ConnectivityDataSource {

    override fun observeNetworkState(): Flow<NetworkState> {
        return callbackFlow {
            trySend()
        }
    }


    /**
     * Récupère la [WifiInfo] d'une façon propre selon la version d'Android.
     * - Android 12+ : via NetworkCapabilities.transportInfo
     * - Avant : via WifiManager.connectionInfo
     */
    private fun currentWifiInfo(caps: NetworkCapabilities?): WifiInfo? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            caps?.transportInfo as? WifiInfo
        } else {
            // On ignore le warning "deprecated" de Android studio ici
            runCatching { wifiManager.connectionInfo }.getOrNull()
        }
    }

    /**
     * Vérifie si [NetworkCapabilities] correspondentà une connexion Wi-Fi.
     *
     * Conditions :
     * - Le réseau doit avoir la capacité [NET_CAPABILITY_INTERNET].
     * - Le réseau doit être validé par le système ([NET_CAPABILITY_VALIDATED]).
     * - Le transport doit être du Wi-Fi ([TRANSPORT_WIFI]).
     *
     * @receiver [NetworkCapabilities]? L’objet représentant les capacités du réseau.
     * Peut être `null` si aucune info n’est disponible.
     *
     * @return `true` si connecté à un Wi-Fi valide avec Internet, sinon `false`.
     */
    private fun NetworkCapabilities?.isConnectedWifi(): Boolean {
        if (this == null)
        {
            return false
        }
        val hasInternet = hasCapability(NET_CAPABILITY_INTERNET)
        val isValidated = hasCapability(NET_CAPABILITY_VALIDATED)
        val isWifi = hasTransport(TRANSPORT_WIFI)
        return hasInternet && isValidated && isWifi
    }
}