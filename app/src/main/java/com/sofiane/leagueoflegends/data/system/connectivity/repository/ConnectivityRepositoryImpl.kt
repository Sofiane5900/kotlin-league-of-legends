package com.sofiane.leagueoflegends.data.system.connectivity.repository

import com.sofiane.leagueoflegends.data.system.connectivity.ConnectivityDataSource
import com.sofiane.leagueoflegends.data.system.connectivity.NetworkState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ConnectivityRepositoryImpl @Inject constructor(
    private val dataSource: ConnectivityDataSource
) : ConnectivityRepository {

    override fun networkState(): Flow<NetworkState> {
        return dataSource.observeNetworkState()
    }
}