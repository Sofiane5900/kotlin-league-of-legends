package com.sofiane.leagueoflegends.ui.screen.championDetails.composable

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.sofiane.leagueoflegends.data.remote.ddragon.RiotImageConstant
import com.sofiane.leagueoflegends.domain.model.PassiveModel

@Composable
fun ChampionPassive(
    passive: PassiveModel,
    modifier: Modifier = Modifier
) {
    ListItem(
        headlineContent = {
            Text(text = passive.name ?: "test")
        },
        supportingContent = {
            Text(text = passive.description ?: "test")
        },
        leadingContent = {
            AsyncImage(
                model = RiotImageConstant.PASSIVE + "${passive.imageModel?.full}",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    )
}