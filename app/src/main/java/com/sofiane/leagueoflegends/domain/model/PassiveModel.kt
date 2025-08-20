package com.sofiane.leagueoflegends.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PassiveModel(
    @SerialName("description")
    val description: String? = "",
    @SerialName("image")
    val imageModel: ImageModel? = ImageModel(),
    @SerialName("name")
    val name: String? = ""
)