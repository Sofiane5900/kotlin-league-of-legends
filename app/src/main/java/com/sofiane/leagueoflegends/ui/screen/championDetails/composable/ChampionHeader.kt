package com.sofiane.leagueoflegends.ui.screen.championDetails.composable

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.sofiane.leagueoflegends.data.ddragon.RiotImageConstant
import com.sofiane.leagueoflegends.data.repository.ChampionRepositoryImpl
import com.sofiane.leagueoflegends.domain.model.ChampionModel
import com.sofiane.leagueoflegends.ui.theme.LeagueoflegendsTheme

@Composable
fun ChampionHeader(
    champion: ChampionModel,
    modifier: Modifier = Modifier
) {
    ListItem(
        modifier = modifier,
        headlineContent = {
            Text(
                text = champion.name ?: "test",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        },
        supportingContent = {
            Text(
                text = champion.tags?.firstOrNull() ?: "test"
            )
        },
        leadingContent = {
            AsyncImage(
                model = RiotImageConstant.SQUARE + "${champion.id}.png",
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )

        },
        trailingContent = {
            Text(
                text = champion.title ?: "test",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    )
    
}

@Preview(showBackground = true)
@Composable
private fun ChampionHeaderPrev() {
    LeagueoflegendsTheme {
      //  ChampionHeader( )
    }
}