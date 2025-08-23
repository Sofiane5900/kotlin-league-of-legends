package com.sofiane.leagueoflegends.ui.screen.championDetails

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sofiane.leagueoflegends.domain.model.ChampionModel
import com.sofiane.leagueoflegends.domain.repository.ChampionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChampionDetailsViewModel @Inject constructor(
    private val championRepository: ChampionRepository
) : ViewModel() {
    var champion = mutableStateOf<ChampionModel?>(null)

    init {
        viewModelScope.launch {
            championRepository.getChampionByName( )
        }
    }
}