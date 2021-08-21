package com.bsp.basekotlin.data.model

import com.google.gson.annotations.SerializedName

data class FilmItem(
    @SerializedName( "id") val id: String = "",
    @SerializedName( "manufacturer") val manufacturer: String = "",
    @SerializedName( "year") val year: String = "",
    @SerializedName( "title") val title: String = "",
    @SerializedName( "image") val image: String = "",
    @SerializedName( "director") val director: String = "",
    @SerializedName( "actor") val actor: String = "",
    @SerializedName( "duration") val duration: String = "",
    @SerializedName( "category") val category: String = "",
    @SerializedName( "link") val link: String = "",
    @SerializedName( "description") val description: String = "",
    @SerializedName( "views") val view: Int = 0
)