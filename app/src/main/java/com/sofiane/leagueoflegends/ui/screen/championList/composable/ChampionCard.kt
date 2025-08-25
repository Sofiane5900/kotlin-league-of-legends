package com.sofiane.leagueoflegends.ui.screen.championList.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.sofiane.leagueoflegends.data.remote.ddragon.RiotImageConstant
import com.sofiane.leagueoflegends.domain.model.ChampionModel
import com.sofiane.leagueoflegends.domain.model.ImageModel
import com.sofiane.leagueoflegends.ui.theme.LeagueoflegendsTheme
import com.sofiane.leagueoflegends.ui.theme.goldBrush

// TODO(Benji):kdoc sur les compasables qui ne sont pas un screen. Mais très bien d'avoir mis un preview et passer le modifier !
@Composable
fun ChampionCard(champion: ChampionModel, modifier: Modifier = Modifier) {
    // TODO(Benji):nit: A faire partout -> mettre "= Column" plutot que "} \n Column("
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            // TODO(Benji):Pas d'appel au d'autres couche que présentation ici, on casse les principes SOLID
            model = RiotImageConstant.SQUARE + "${champion.id}.png",
            contentDescription = champion.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .aspectRatio(1f)
                .border(
                    BorderStroke(1.dp, goldBrush),
                    RoundedCornerShape(50.dp)
                )
                .clip(RoundedCornerShape(50.dp))
        )

        // TODO(Benji):Pourquoi mettre une colonne avec un seul element ? On est déjà dans une colonne
        Column(
            modifier = Modifier
                .padding(vertical = 10.dp)
        ) {
            Text(
                text = champion.name ?: "test",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ChampionCardPreview() { // TODO(Benji):Pareil: mettre un "=" pour ganger une indentation et en lisibilité. A faire partout.
    LeagueoflegendsTheme {
        ChampionCard(
            champion = ChampionModel(
                id = "Aatrox",
                name = "Aatrox",
                imageModel = ImageModel(full = "Aatrox.png")
            )
        )
    }
}