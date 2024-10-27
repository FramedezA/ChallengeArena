package com.example.network.data.data_structures

import com.google.gson.annotations.SerializedName

data class RefreshResponse(
    @SerializedName("id")
    val id:Int,
    @SerializedName("username")
    val userName:String,
    @SerializedName("accessToken")
    val accessToken:String,
    @SerializedName("refreshToken")
    val refreshToken:String
)
