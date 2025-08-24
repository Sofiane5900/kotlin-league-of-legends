package com.sofiane.leagueoflegends.data.di

import android.content.Context
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import com.sofiane.leagueoflegends.data.system.connectivity.ConnectivityDataSource
import com.sofiane.leagueoflegends.data.system.connectivity.ConnectivityDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ConnectivityModule {
    @Provides
    fun provideConnectivityManager(@ApplicationContext context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @Provides
    fun provideWifiManager(@ApplicationContext context: Context): WifiManager {
       return context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
    }


    @Provides
    @Singleton
    fun provideConnectivityDataSource(
        cm: ConnectivityManager,
        wifi: WifiManager
    ): ConnectivityDataSource {
        return ConnectivityDataSourceImpl(cm, wifi)
    }



}