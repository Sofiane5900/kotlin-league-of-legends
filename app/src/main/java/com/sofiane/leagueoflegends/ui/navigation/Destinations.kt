package com.sofiane.leagueoflegends.ui.navigation

import kotlinx.serialization.Serializable


class Routes {


@Serializable
data object ChampionList

@Serializable
data class ChampionDetails(val name: String)

}