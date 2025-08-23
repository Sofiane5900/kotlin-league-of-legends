package com.sofiane.leagueoflegends.ui.screen.championDetails

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.sofiane.leagueoflegends.data.ddragon.RiotImageConstant
import com.sofiane.leagueoflegends.domain.model.ChampionModel
import com.sofiane.leagueoflegends.ui.screen.championDetails.composable.ChampionHeader
import com.sofiane.leagueoflegends.ui.screen.championDetails.composable.ChampionLore
import com.sofiane.leagueoflegends.ui.screen.championDetails.composable.ChampionPassive
import com.sofiane.leagueoflegends.ui.screen.championDetails.composable.ChampionSpell

@Composable
fun ChampionDetailsScreen(
    champion: ChampionModel,

) {
    Scaffold { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding
        ) {
            item {
                AsyncImage(
                    model = RiotImageConstant.SPLASH + "${champion.id}_0.jpg",
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )

                ChampionHeader(
                    champion = champion,
                    modifier = Modifier.padding(
                        horizontal = 10.dp,
                        vertical = 6.dp,
                    )
                )

                ChampionLore(
                    lore = champion.lore ?: "test",
                    modifier = Modifier.padding(
                        horizontal = 20.dp,
                        vertical = 6.dp
                    )
                )

                champion.passiveModel?.let { passive ->
                    ChampionPassive(
                        passive = passive,
                        modifier = Modifier.padding(
                            horizontal = 6.dp,
                            vertical = 10.dp
                        )
                    )
                }

                champion.spellModels?.forEach { spellModel ->
                    ChampionSpell(
                        spell = spellModel,
                        modifier = Modifier.padding(
                            horizontal = 6.dp,
                            vertical = 10.dp
                        )
                    )

                }
            }
        }
    }
}