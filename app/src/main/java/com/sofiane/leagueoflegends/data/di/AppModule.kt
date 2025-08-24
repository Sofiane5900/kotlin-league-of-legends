package com.sofiane.leagueoflegends.data.di

import com.sofiane.leagueoflegends.data.remote.repository.ChampionRepositoryImpl
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

/**
 * Module Dagger Hilt qui fournit les dépendances HTTP et repository pour l’application.
 *
 * Ici on configure :
 * - un [HttpClient] basé sur OkHttp pour consommer l’API Riot Data Dragon,
 * - un [ChampionRepository] qui encapsule les appels à l’API.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    /**
     * Fournit une instance unique de [HttpClient].
     *
     * - Utilise le moteur OkHttp.
     * - Configure une requête par défaut avec :
     *   - L’URL de base des données Riot ([ChampionRepositoryImpl.BASE_URL]).
     *   - L’en-tête `"Content-Type: application/json"`.
     * - Installe le plugin [ContentNegotiation] avec Kotlinx Serialization,
     *   configuré pour ignorer les champs inconnus dans le JSON.
     *
     * @return Une instance singleton de [HttpClient].
     */
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

    /**
     * Fournit une implémentation de [ChampionRepository].
     *
     * Cette implémentation ([ChampionRepositoryImpl]) utilise
     * le [HttpClient] configuré ci-dessus pour interagir avec l’API Riot Data Dragon.
     *
     * @param httpClient Le client HTTP fourni par [provideHttpClient].
     * @return Une instance singleton de [ChampionRepository].
     */
    @Provides
    @Singleton
    fun provideChampionRepository(httpClient: HttpClient): ChampionRepository
    {
       return ChampionRepositoryImpl(httpClient = httpClient)
    }
}