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
import kotlinx.coroutines.channels.awaitClose
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

    /**
     * Observe en temps réel l’état du réseau avec [Flow].
     *
     * - Émet une fois l’état courant via [buildState].
     * - Écoute ensuite les callbacks du [ConnectivityManager] :
     *   - [onAvailable] : lorsqu’un réseau devient disponible.
     *   - [onLost] : lorsqu’un réseau est perdu.
     *   - [onCapabilitiesChanged] : lorsqu’un réseau change de capacités.
     * - Se désinscrit automatiquement à la fermeture du flow.
     *
     * @return Un [Flow] émettant un [NetworkState] à chaque changement de "connectivité".
     */
    override fun observeNetworkState(): Flow<NetworkState> {
        return callbackFlow {
            trySend(buildState())
            // callback appelé à chaque changement de réseau
            val callback = object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    trySend(buildState(network)).isSuccess
                }
                override fun onLost(network: Network) {
                    trySend(buildState()).isSuccess
                }
                override fun onCapabilitiesChanged(network: Network, caps: NetworkCapabilities) {
                    trySend(buildState(network)).isSuccess
                }
            }
            connectivityManager.registerDefaultNetworkCallback(callback)
            awaitClose { connectivityManager.unregisterNetworkCallback(callback) }
        }
    }


    /**
     * Construit un [NetworkState] à partir du réseau actif (ou d’un [network] donné).
     *
     * - Vérifie si le réseau est bien un Wi-Fi.
     * - Rrécupère le SSID et l’intensité du signal (RSSI).
     *
     * @param network Réseau à observer, ou celui actif par défaut.
     * @return Un [NetworkState] représentant l’état de la connexion Wi-Fi.
     */
    private fun buildState(network: Network? = connectivityManager.activeNetwork): NetworkState {
        // caps = abréviation de NetworkCapabilities
        val caps = runCatching { connectivityManager.getNetworkCapabilities(network) }.getOrNull()
        val connectedWifi = caps.isConnectedWifi()

        // Valeurs par défaut = non connecté au wifi
        var ssid: String? = null
        var rssi: Int? = null

        if (connectedWifi) {
            val info = currentWifiInfo(caps)
            // unknow ssid si jamais la location n'est pas activté
            ssid = info?.ssid?.trim('"')
            rssi = info?.rssi
        }

        return NetworkState(
            isConnected = connectedWifi,
            ssid = ssid,
            signalDbm = rssi
        )
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