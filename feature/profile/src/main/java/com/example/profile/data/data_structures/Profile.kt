package com.example.profile.data.data_structures

import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("id")
    val id :Int?,
    @SerializedName("name")
    var name:String?,
    @SerializedName("username")
    var login:String?,
    @SerializedName("goals")
    var goals:String?,
    @SerializedName("age")
    var age:Int?,
    @SerializedName("description")
    var description:String?,
    @SerializedName("sex")
    var sex :Int?
){
    fun getProfileRequest() = ProfileRequest(name,login,goals,age,description,sex)
}
