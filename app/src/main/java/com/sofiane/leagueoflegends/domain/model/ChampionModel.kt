package com.sofiane.leagueoflegends.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Représente un champion League of Legends
 *
 * Ce modéle est utilisé pour désérialiser la réponse JSON de l'API Riot Data Dragon.
 *
 * @property id Identifiant texte unique du champion (ex: `"Aatrox"`).
 * @property imageModel Informations sur l’icône du champion (sprite, chemin d’image).
 * @property key Identifiant numérique du champion fourni par Riot (ex: `"266"`).
 * @property lore Histoire complète (description longue) du champion.
 * @property name Nom affiché du champion (ex: `"Aatrox"`).
 * @property passiveModel Compétence passive du champion (ex: `"Deathbringer Stance"`).
 * @property spellModels Liste des compétences actives (Q, W, E, R).
 * @property tags Rôles/classes du champion (ex: `"Fighter"`, `"Tank"`).
 * @property title Surnom ou sous-titre du champion (ex: `"the Darkin Blade"`).
 */
@Serializable
data class ChampionModel(
    @SerialName("id")
    val id: String? = "",
    @SerialName("image")
    val imageModel: ImageModel? = ImageModel(),
    @SerialName("key")
    val key: String? = "",
    @SerialName("lore")
    val lore: String? = "",
    @SerialName("blurb")
    val blurb: String? = "",
    @SerialName("name")
    val name: String? = "",
    @SerialName("passive")
    val passiveModel: PassiveModel? = PassiveModel(),
    @SerialName("spells")
    val spellModels: List<SpellModel>? = emptyList(),
    @SerialName("tags")
    val tags: List<String>? = listOf(),
    @SerialName("title")
    val title: String? = ""
)

fun Map<String, ChampionModel>.toChampionList(): List<ChampionModel> =
    this.values.toList()