package com.sofiane.leagueoflegends.ui.screen.championList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sofiane.leagueoflegends.domain.model.ChampionModel
import com.sofiane.leagueoflegends.ui.screen.championList.composable.ChampionCard

@Composable
fun ChampionListScreen(
    state: ChampionListState,
    onValueChange: (String) -> Unit,
    navigate: (String) -> Unit,
)
{
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 20.dp)

        ) {
            OutlinedTextField(
                value = state.searchText,
                onValueChange = onValueChange,
                placeholder = {
                    Text(text = "Rechercher des champions")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = null
                    )
                },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            )
            LazyVerticalGrid(
                columns = GridCells.Adaptive(100.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ){
                items(state.filteredChampions.ifEmpty { state.champions }) { champions ->
                    ChampionCard(
                        champion = champions,
                        modifier = Modifier.animateItem()
                            .clickable {
                                champions.name?.let(navigate)
                            }
                    )
                }

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ChampionListScreenPreview() {
    val fakeState = ChampionListState(
        champions = listOf(
            ChampionModel(id = "Aatrox", name = "Aatrox"),
            ChampionModel(id = "Ahri", name = "Ahri"),
            ChampionModel(id = "Akali", name = "Akali")
        )
    )
}


