package com.sofiane.leagueoflegends

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sofiane.leagueoflegends.ui.screen.championList.ChampionListScreen
import com.sofiane.leagueoflegends.ui.screen.championList.ChampionListViewModel
import com.sofiane.leagueoflegends.ui.theme.LeagueoflegendsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LeagueoflegendsTheme {
                val viewModel = hiltViewModel<ChampionListViewModel>()
                val state by viewModel.state.collectAsStateWithLifecycle()
                ChampionListScreen(
                    state = state,
                    onValueChange = viewModel::onSearchTextChange

                    )
                }
            }
        }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LeagueoflegendsTheme {
        Greeting("Android")
    }
}