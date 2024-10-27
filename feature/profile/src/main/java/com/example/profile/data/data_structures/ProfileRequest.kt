package com.example.profile.data.data_structures

import com.google.gson.annotations.SerializedName

data class ProfileRequest(
    @SerializedName("name")
    val name:String?,
    @SerializedName("username")
    val login:String?,
    @SerializedName("goals")
    val goals:String?,
    @SerializedName("age")
    val age:Int?,
    @SerializedName("description")
    val description:String?,
    @SerializedName("sex")
    val sex :Int?
)
