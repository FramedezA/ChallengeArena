package com.example.login.data

interface LoginStorage {

    val defaultValue: String

    fun saveUserLogged(bool:Boolean)
    fun saveUserName(userName:String)

    fun saveId(id:String?)
    fun saveAccessToken(token:String)
    fun saveRefreshToken(token:String)

    fun getId():String?
}