package com.catsapi.data.models

import com.catsapi.ui.models.CatbreedBinding
import com.google.gson.annotations.SerializedName

data class CatbreedResponse (
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("origin")
    val country: String,

    @SerializedName("intelligence")
    val intelligence: String,

    @SerializedName("reference_image_id")
    val imageId: String? = "",
) {
    fun toBinding(): CatbreedBinding {
        return CatbreedBinding(
            id = id,
            name = name,
            country = country,
            intelligence = intelligence,
            imageId = imageId ?: ""
        )
    }
}