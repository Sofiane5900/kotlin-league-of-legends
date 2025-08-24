package com.sofiane.leagueoflegends.ui.screen.wifi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sofiane.leagueoflegends.data.system.connectivity.NetworkState
import com.sofiane.leagueoflegends.data.system.connectivity.repository.ConnectivityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

/**
 * ViewModel qui expose l’état actuel de la connexion Wi-Fi.
 *
 * - Récupère les infos depuis [ConnectivityRepository].
 * - Fournit un [StateFlow] que l’UI peut observer en temps réel.
 *
 * @property state [StateFlow] qui émet en continu l’état du réseau Wi-Fi.
 *   - `isConnected = true` si un Wi-Fi valide est connecté.
 *   - `ssid` contient le nom du réseau (si disponible).
 *   - `signalDbm` indique l’intensité du signal en dBm.
 */
@HiltViewModel
class WifiViewModel @Inject constructor(
    repository: ConnectivityRepository
) : ViewModel() {
     val state: StateFlow<NetworkState> =
         repository.networkState()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                NetworkState(isConnected = false))
}
