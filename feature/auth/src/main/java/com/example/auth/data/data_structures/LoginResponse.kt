package com.example.auth.data.data_structures

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("username")
    val userName: String,
    @SerializedName("accessToken")
    val accessToken: String,
    @SerializedName("refreshToken")
    val refreshToken: String
)
