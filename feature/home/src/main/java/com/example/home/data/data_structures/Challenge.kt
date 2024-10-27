package com.example.home.data.data_structures

import com.google.gson.annotations.SerializedName

data class Challenge(
    @SerializedName("id")
    val id: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("rules")
    val rules: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("date")
    val date: String
)
