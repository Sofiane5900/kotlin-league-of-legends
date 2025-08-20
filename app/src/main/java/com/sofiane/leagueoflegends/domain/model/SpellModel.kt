package com.sofiane.leagueoflegends.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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