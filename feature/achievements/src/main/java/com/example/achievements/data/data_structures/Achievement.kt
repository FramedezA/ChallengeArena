package com.example.achievements.data.data_structures

import com.google.gson.annotations.SerializedName

data class Achievement(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
)
