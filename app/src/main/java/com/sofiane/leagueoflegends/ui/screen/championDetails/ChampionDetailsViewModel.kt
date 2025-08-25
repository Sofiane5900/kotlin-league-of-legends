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
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    // TODO : Si tu as fait le choix de passer par des states dans tes autres vues, ça ne devrait pas être le cas ici ? Ou alors ne pas utiliser de State (sous entendu classe à part du VM) nulle part.
    var champion = mutableStateOf<ChampionModel?>(null)

    init {
        // TODO(Benji):C'est pas mal et c'est correct, mais je ne mettrait pas la partie navigation dans le VM -> pour moi c'est la responsabilité de la vue.
        val args = savedStateHandle.toRoute<Routes.ChampionDetails>()
        viewModelScope.launch {
            championRepository.getChampionByName(args.name)
                .onSuccess { champion.value = data.champion.values.firstOrNull() }
                // TODO(Benji):renvoyer un error message en cas de failure
                .onFailure { }
        }
    }
}