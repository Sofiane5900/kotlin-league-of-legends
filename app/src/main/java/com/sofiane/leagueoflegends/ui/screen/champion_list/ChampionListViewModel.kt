package com.sofiane.leagueoflegends.ui.screen.champion_list

import androidx.lifecycle.ViewModel
import com.sofiane.leagueoflegends.domain.repository.ChampionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChampionListViewModel @Inject constructor(
    private val championRepository: ChampionRepository
) : ViewModel() {

}