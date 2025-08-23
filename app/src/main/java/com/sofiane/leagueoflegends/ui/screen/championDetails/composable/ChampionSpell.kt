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
import com.sofiane.leagueoflegends.core.util.RiotImageConstant
import com.sofiane.leagueoflegends.domain.model.SpellModel

@Composable
fun ChampionSpell(
    spell: SpellModel,
    modifier: Modifier = Modifier
) {
    ListItem(
        headlineContent = {
            Text(text = spell.name ?: "test")
        },
        supportingContent = {
            Text(text = spell.description ?: "test")
        },
        leadingContent = {
            AsyncImage(
                model = RiotImageConstant.SPELL + "${spell.id}.png",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    )
}