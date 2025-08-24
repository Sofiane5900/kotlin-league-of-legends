package com.sofiane.leagueoflegends.data.system.connectivity.repository

import com.sofiane.leagueoflegends.data.system.connectivity.NetworkState
import kotlinx.coroutines.flow.Flow

/**
 * Interface pour accéder à l’état réseau de l’appareil.
 *
 * Encapsule le [ConnectivityDataSource] et expose un flow
 * de [NetworkState] utilisable par l’UI ou les ViewModels.
 * */
interface ConnectivityRepository {
    /**
     * Observe en temps réel la réseau Wi-Fi.
     *
     * @return Un [Flow] émettant un [NetworkState] à chaque changement
     * de connectivité détecté par le système.
     */
    fun networkState(): Flow<NetworkState>
}