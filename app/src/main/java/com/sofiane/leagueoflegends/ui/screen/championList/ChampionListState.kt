package com.sofiane.leagueoflegends.ui.screen.championList

import com.sofiane.leagueoflegends.domain.model.ChampionModel

/*
 TODO : filteredChampions est un champs calculé, il ne faudrait pas avoir à le renseigner.
C'est comme mettre :
data class AdditionState(
    val nb1: Int,
    val nb2: Int,
    val result: Int,
)
 */
data class ChampionListState(
    val searchText: String = "",
    val champions: List<ChampionModel> = emptyList(),
    val filteredChampions: List<ChampionModel> = emptyList() // nit: on met toujours la virgule à la fin sur plusieurs lignes (règle kotlin), et ça aide enormement (quand tu rajoutes des lignes et que tu duplique par exemple)
)
