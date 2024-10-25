package com.example.auth.data.data_structures

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @field:SerializedName("name") val name: String,
    @field:SerializedName("username") val username: String,
    @field:SerializedName("password") val password: String,
    @field:SerializedName("passwordConfirmation") val passwordConfirmation: String
)
