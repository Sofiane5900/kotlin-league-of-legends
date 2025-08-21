package com.sofiane.leagueoflegends.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable



/**
 * Représente une compétence active d’un champion (Q, W, E ou R).
 *
 * Chaque champion possède entre 4 et 5 sorts actifs
 * (les 4 basiques + éventuellement un sort additionnel).
 *
 * @property description Texte descriptif détaillant l’effet du sort.
 * @property id Identifiant unique du sort (ex: `"AatroxQ"`).
 * @property imageModel Informations sur l’icône du sort.
 * @property name Nom affiché du sort (ex: `"The Darkin Blade"`).
 */
@Serializable
data class SpellModel(
    @SerialName("description")
    val description: String? = "",
    @SerialName("id")
    val id: String? = "",
    @SerialName("image")
    val imageModel: ImageModel? = ImageModel(),
    @SerialName("name")
    val name: String? = ""
)