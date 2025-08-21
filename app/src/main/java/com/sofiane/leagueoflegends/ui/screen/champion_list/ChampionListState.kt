package com.sofiane.leagueoflegends.ui.screen.champion_list

import com.sofiane.leagueoflegends.domain.model.ChampionModel

data class ChampionListState(
    val searchText: String =  "",
    val champions: List<ChampionModel> = emptyList()
)
