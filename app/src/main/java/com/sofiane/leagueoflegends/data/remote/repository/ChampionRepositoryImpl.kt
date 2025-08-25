package com.sofiane.leagueoflegends.data.remote.repository

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.ktor.getApiResponse
import com.sofiane.leagueoflegends.data.remote.ChampionRemoteDataSource
import com.sofiane.leagueoflegends.domain.model.ChampionResponseModel
import com.sofiane.leagueoflegends.domain.repository.ChampionRepository
import io.ktor.client.HttpClient

class ChampionRepositoryImpl(
    private val dataSource: ChampionRemoteDataSource,
) : ChampionRepository {
    companion object {
        // TODO : ajouter l'url dans un fichier .env -> TODO(Benji): Non ! Et ce n'est pas utilisé par le repo (et c'est normal), ça ne devrait pas être ici.
        const val BASE_URL = "https://ddragon.leagueoflegends.com/cdn/15.16.1/data/fr_FR"
    }

    override suspend fun getAllChampions(): ApiResponse<ChampionResponseModel> {
       return dataSource.fetchAllChampions()
    }

    override suspend fun getChampionByName(name: String): ApiResponse<ChampionResponseModel> {
        return dataSource.fetchChampionByName(name)
    }
}