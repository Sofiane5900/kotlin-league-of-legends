package com.sofiane.leagueoflegends.data.system.connectivity

import kotlinx.coroutines.flow.Flow

/** Expose l'état réseau en temps réel à travers un [Flow]. */
interface ConnectivityDataSource {
    fun observeNetworkState(): Flow<NetworkState>
}