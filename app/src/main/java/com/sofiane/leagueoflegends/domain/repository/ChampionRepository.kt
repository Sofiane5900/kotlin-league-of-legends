package com.sofiane.leagueoflegends.domain.repository

import com.skydoves.sandwich.ApiResponse
import com.sofiane.leagueoflegends.domain.model.ChampionResponseModel

interface ChampionRepository {
    suspend fun getAllChampions(): ApiResponse<ChampionResponseModel>
    suspend fun getChampionByName(name: String): ApiResponse<ChampionResponseModel>
}