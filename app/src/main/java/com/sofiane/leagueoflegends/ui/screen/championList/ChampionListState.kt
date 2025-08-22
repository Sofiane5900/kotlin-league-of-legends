package com.sofiane.leagueoflegends.ui.screen.championList

import com.sofiane.leagueoflegends.domain.model.ChampionModel

data class ChampionListState(
    val searchText: String =  "",
    val champions: List<ChampionModel> = emptyList(),
    val filteredChampions: List<ChampionModel> = emptyList()
)
