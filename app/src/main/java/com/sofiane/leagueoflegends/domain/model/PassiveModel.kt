package com.sofiane.leagueoflegends.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Représente la compétence passive d’un champion.
 *
 * Chaque champion de League of Legends possède une
 * compétence passive unique, décrite par un nom,
 * une description et une icône.
 *
 * @property description Texte descriptif de l’effet de la passive.
 * @property imageModel Informations sur l’icône associée à la passive.
 * @property name Nom de la compétence passive (ex: `"Deathbringer Stance"`).
 */
@Serializable
data class PassiveModel(
    @SerialName("description")
    val description: String? = "",
    @SerialName("image")
    val imageModel: ImageModel? = ImageModel(),
    @SerialName("name")
    val name: String? = ""
)