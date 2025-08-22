package com.sofiane.leagueoflegends.data.repository

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.ktor.getApiResponse
import com.sofiane.leagueoflegends.domain.model.ChampionResponseModel
import com.sofiane.leagueoflegends.domain.repository.ChampionRepository
import io.ktor.client.HttpClient
class ChampionRepositoryImpl(
    private val httpClient: HttpClient
) : ChampionRepository {
    companion object {
        // TODO : ajouter l'url dans un fichier .env
        const val BASE_URL = "https://ddragon.leagueoflegends.com/cdn/15.16.1/data/fr_FR"


    }
    override suspend fun getAllChampions(): ApiResponse<ChampionResponseModel> {
       return httpClient.getApiResponse<ChampionResponseModel>("$BASE_URL/champion.json")
    }


    override suspend fun getChampionByName(name: String): ApiResponse<ChampionResponseModel> {
       return httpClient.getApiResponse<ChampionResponseModel>("$BASE_URL/champion/$name.json")    }
}