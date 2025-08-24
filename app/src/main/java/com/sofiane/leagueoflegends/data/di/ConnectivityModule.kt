package com.sofiane.leagueoflegends.data.di

import android.content.Context
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import com.sofiane.leagueoflegends.data.system.connectivity.ConnectivityDataSource
import com.sofiane.leagueoflegends.data.system.connectivity.ConnectivityDataSourceImpl
import com.sofiane.leagueoflegends.data.system.connectivity.repository.ConnectivityRepository
import com.sofiane.leagueoflegends.data.system.connectivity.repository.ConnectivityRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Module Dagger Hilt qui fournit les deps de connectivity/.
 *
 * - Expose le [ConnectivityManager] et le [WifiManager] en singleton.
 * - Fournit une impl oncrète de [ConnectivityDataSource] ([ConnectivityDataSourceImpl]).
 *
 * Ce module est installé dans [SingletonComponent], donc ses instances vivent
 * pendant toute la durée de vie de l’application.
 */
@Module
@InstallIn(SingletonComponent::class)
object ConnectivityModule {
    /**
     * Fournit le [ConnectivityManager] Android à partir du [Context] de l’application.
     *
     * @param context Le contexte application injecté par Hilt.
     * @return Une instance de [ConnectivityManager].
     */
    @Provides
    fun provideConnectivityManager(@ApplicationContext context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    /**
     * Fournit le [WifiManager] Android à partir du [Context] de l’application.
     *
     * @param context Le contexte application injecté par Hilt.
     * @return Une instance de [WifiManager].
     */
    @Provides
    fun provideWifiManager(@ApplicationContext context: Context): WifiManager {
       return context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
    }


    /**
     * Fournit une implémentation de [ConnectivityDataSource] qui expose l’état
     * du réseau via un [kotlinx.coroutines.flow.Flow].
     *
     * @param cm Le [ConnectivityManager] Android.
     * @param wifi Le [WifiManager] Android.
     * @return Une instance singleton de [ConnectivityDataSourceImpl].
     */
    @Provides
    @Singleton
    fun provideConnectivityDataSource(
        cm: ConnectivityManager,
        wifi: WifiManager
    ): ConnectivityDataSource {
        return ConnectivityDataSourceImpl(cm, wifi)
    }

    /**
     * Fournit une implémentation de [ConnectivityRepository] qui manipule le
     * le [ConnectivityDataSource].
     *
     * @param dataSource l’implémentation de [ConnectivityDataSource].
     * @return Une instance singleton de [ConnectivityRepository].
     */
    @Provides
    @Singleton
    fun provideConnectivityRepository(
        dataSource: ConnectivityDataSource
    ): ConnectivityRepository {
        return ConnectivityRepositoryImpl(dataSource)
    }
}