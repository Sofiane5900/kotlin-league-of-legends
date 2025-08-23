package com.sofiane.leagueoflegends

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sofiane.leagueoflegends.ui.navigation.ChampionDetails
import com.sofiane.leagueoflegends.ui.navigation.ChampionList
import com.sofiane.leagueoflegends.ui.screen.championDetails.ChampionDetailsScreen
import com.sofiane.leagueoflegends.ui.screen.championDetails.ChampionDetailsViewModel
import com.sofiane.leagueoflegends.ui.screen.championList.ChampionListScreen
import com.sofiane.leagueoflegends.ui.screen.championList.ChampionListViewModel
import com.sofiane.leagueoflegends.ui.theme.LeagueoflegendsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeagueoflegendsTheme {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = ChampionList)
                    {
                        composable<ChampionList> {
                            val viewModel = hiltViewModel<ChampionListViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()
                            ChampionListScreen(
                                state = state,
                                onValueChange = viewModel::onSearchTextChange,
                                navigate = {name ->
                                    navController.navigate(ChampionDetails(name))
                                }
                            )

                        }
                        composable<ChampionDetails> {
                            val viewModel = hiltViewModel<ChampionDetailsViewModel>()
                            viewModel.champion.value?.let{
                                ChampionDetailsScreen(champion = it)
                            }


                        }
                    }
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