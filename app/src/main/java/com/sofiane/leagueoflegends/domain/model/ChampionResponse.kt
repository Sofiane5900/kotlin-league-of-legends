package com.sofiane.leagueoflegends.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChampionResponse(
    @SerialName("data")
    val `data`: Map<String, ChampionModel> = emptyMap(),
    @SerialName("format")
    val format: String? = "",
    @SerialName("type")
    val type: String? = "",
    @SerialName("version")
    val version: String? = ""
)