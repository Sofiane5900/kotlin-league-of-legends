package com.sofiane.leagueoflegends.data.di

import com.sofiane.leagueoflegends.data.repository.ChampionRepositoryImpl
import com.sofiane.leagueoflegends.domain.repository.ChampionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient
    {
        return HttpClient(OkHttp.create())
        {
            defaultRequest {
                url(ChampionRepositoryImpl.BASE_URL)
                header("Content-Type", "application/json")
            }
            install(ContentNegotiation)
            {
                json(
                    Json {
                        // ignore les champs non spécifiée dans notre model du json de l'api riot
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }

    @Provides
    @Singleton
    fun provideChampionRepository(httpClient: HttpClient): ChampionRepository
    {
       return ChampionRepositoryImpl(httpClient = httpClient)
    }
}