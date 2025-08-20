package com.sofiane.leagueoflegends.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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