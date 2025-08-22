package com.sofiane.leagueoflegends.ui.screen.championList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skydoves.sandwich.onSuccess
import com.sofiane.leagueoflegends.domain.model.toChampionList
import com.sofiane.leagueoflegends.domain.repository.ChampionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChampionListViewModel @Inject constructor(
    private val championRepository: ChampionRepository
) : ViewModel() {
    private val _state = MutableStateFlow(ChampionListState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            championRepository.getAllChampions()
                .onSuccess {
                    _state.update {
                        it.copy(
                            champions = data.champion.toChampionList()
                        )
                    }
                }
        }
    }

    fun onSearchTextChange(text: String)
    {
        _state.update {
            it.copy(
                searchText = text,
                filteredChampions = it.champions.filter { championModel ->
                    championModel.name?.contains(text, ignoreCase = true) == true
                }
            )
        }
    }

}