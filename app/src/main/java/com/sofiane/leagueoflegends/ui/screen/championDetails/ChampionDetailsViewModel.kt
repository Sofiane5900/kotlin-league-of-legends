package com.sofiane.leagueoflegends.ui.screen.championDetails

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.onSuccess
import com.sofiane.leagueoflegends.domain.model.ChampionModel
import com.sofiane.leagueoflegends.domain.repository.ChampionRepository
import com.sofiane.leagueoflegends.ui.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChampionDetailsViewModel @Inject constructor(
    private val championRepository: ChampionRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var champion = mutableStateOf<ChampionModel?>(null)

    init {

        val args = savedStateHandle.toRoute<Routes.ChampionDetails>()
        viewModelScope.launch {
            championRepository.getChampionByName(args.name)
                .onSuccess { champion.value = data.champion.values.firstOrNull() }
                // TODO: renvoyer un error message en cas de failure
                .onFailure { }
        }
    }
}