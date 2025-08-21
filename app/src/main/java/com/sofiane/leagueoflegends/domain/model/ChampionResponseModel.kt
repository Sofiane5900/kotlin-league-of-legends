package com.sofiane.leagueoflegends.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Représente la réponse complète de l'API Riot Data Dragon
 * pour la liste des champions.
 *
 * Exemple : `https://ddragon.leagueoflegends.com/cdn/{version}/data/fr_FR/champion.json`
 *
 * @property data Map contenant la liste des champions,
 * indexés par leur nom (clé : `"Aatrox"`, `"Ahri"`, etc.).
 * Chaque entrée contient un [ChampionModel].
 * @property format Format de la réponse (généralement `"standAloneComplex"`).
 * @property type Type de la ressource (généralement `"champion"`).
 * @property version Version du Data Dragon utilisée (ex: `"15.16.1"`).
 */
@Serializable
data class ChampionResponseModel(
    @SerialName("data")
    val `data`: Map<String, ChampionModel> = emptyMap(),
    @SerialName("format")
    val format: String? = "",
    @SerialName("type")
    val type: String? = "",
    @SerialName("version")
    val version: String? = ""
)