package com.sofiane.leagueoflegends.ui.screen.championList.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sofiane.leagueoflegends.R
import com.sofiane.leagueoflegends.core.util.RiotImageConstant
import com.sofiane.leagueoflegends.domain.model.ChampionModel
import com.sofiane.leagueoflegends.ui.theme.LeagueoflegendsTheme

@Composable
fun ChampionCard(champion: ChampionModel) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        AsyncImage(
            model = RiotImageConstant.RiotImageConstant.LOADING + "${champion.name}_0.jpg",
            painter = painterResource(R.drawable.draven_card),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .weight(0.3f)
                .height(100.dp)
                .clip(RoundedCornerShape(20.dp))
        )

        Column(
            modifier = Modifier
                .weight(0.7f)
                .padding(vertical = 10.dp)
        ) {
            Text(
                text = "Draven",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "testsdfsffftestsdfsffftestsdfsffftestsdfsffftestsdfsffftestsdfsffftestsdfsffftestsdfsffftestsdfsffftestsdfsfff"
            )
        }
    }
}


@Preview
@Composable
private fun ChampionCardPreview() {
    LeagueoflegendsTheme {
        ChampionCard()
    }
}