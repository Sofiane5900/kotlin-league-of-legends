package com.sofiane.leagueoflegends.data.remote

import com.skydoves.sandwich.ApiResponse
import com.sofiane.leagueoflegends.domain.model.ChampionResponseModel

interface ChampionRemoteDataSource {
    suspend fun fetchAllChampions(): ApiResponse<ChampionResponseModel>
    suspend fun fetchChampionByName(name: String): ApiResponse<ChampionResponseModel>

}