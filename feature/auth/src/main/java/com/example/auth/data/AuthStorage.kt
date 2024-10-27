package com.example.auth.data

interface AuthStorage {

    val defaultValue: String

    fun saveUserLogged(bool:Boolean)
    fun saveName(userName:String)

    fun saveId(id:String?)

    fun saveAccessToken(token:String)
    fun saveRefreshToken(token:String)

//    fun saveString(name:String,value: String)

}