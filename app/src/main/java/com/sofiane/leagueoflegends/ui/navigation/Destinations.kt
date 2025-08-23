package com.sofiane.leagueoflegends.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
data object ChampionList

@Serializable
data class ChampionDetails(val name: String)