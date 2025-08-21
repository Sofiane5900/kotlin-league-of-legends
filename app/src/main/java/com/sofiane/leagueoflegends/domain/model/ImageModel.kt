package com.sofiane.leagueoflegends.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Représente les informations d’image fournies par Riot
 * pour un champion, un sort ou une compétence passive.
 *
 * @property full Nom complet du fichier image (ex: `"Aatrox.png"`).
 * @property group Groupe auquel appartient l’image (ex: `"champion"`, `"spell"`, `"passive"`).
 */
@Serializable
data class ImageModel(
    @SerialName("full")
    val full: String? = "",
    @SerialName("group")
    val group: String? = ""
)