package com.sofiane.leagueoflegends.domain.repository

import com.skydoves.sandwich.ApiResponse
import com.sofiane.leagueoflegends.domain.model.ChampionResponseModel

/**
 * Contrat d'accès aux champions de l'API Data Dragon.
 */
interface ChampionRepository {

    /** Récupère tous les champions. */
    suspend fun getAllChampions(): ApiResponse<ChampionResponseModel>

    /** Récupère un champion par son nom (ex: "Aatrox"). */
    suspend fun getChampionByName(name: String): ApiResponse<ChampionResponseModel>
}