package com.sofiane.leagueoflegends.ui.navigation

import kotlinx.serialization.Serializable

// TODO(Benji):Le fichier s'appelle "Destinations", la classe "Route" -> Il faut choisir un ou l'autre (les deux sont valables)
class Routes {
    // TODO(Benji):nit: Trop d'espace ici, ferait une erreur qualité dans nos outils.

    @Serializable
    data object ChampionList

    @Serializable
    data class ChampionDetails(val name: String)

    // TODO : nit: Rien de grave c'est juste du namming : j'avais demandé "un écran de paramètrage avec seulement le wifi d'affiché" -> d'un point de vue métier ça aurait du être un écran de paramètrage.
    @Serializable
    data object Wifi
}
