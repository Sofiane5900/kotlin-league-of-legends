package com.sofiane.leagueoflegends.data.remote

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.ktor.getApiResponse
import com.sofiane.leagueoflegends.data.remote.repository.ChampionRepositoryImpl.Companion.BASE_URL
import com.sofiane.leagueoflegends.domain.model.ChampionResponseModel
import io.ktor.client.HttpClient
import javax.inject.Inject

class ChampionRemoteDataSourceImpl @Inject constructor(
    private val httpClient: HttpClient
): ChampionRemoteDataSource {
    override suspend fun fetchAllChampions(): ApiResponse<ChampionResponseModel> {
        return httpClient.getApiResponse<ChampionResponseModel>("$BASE_URL/champion.json")
    }

    override suspend fun fetchChampionByName(name: String): ApiResponse<ChampionResponseModel> {
        return httpClient.getApiResponse<ChampionResponseModel>("$BASE_URL/champion/$name.json")
    }

}