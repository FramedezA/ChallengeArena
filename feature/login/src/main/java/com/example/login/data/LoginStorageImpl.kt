package com.example.login.data

import android.content.Context
import android.content.SharedPreferences

class LoginStorageImpl(context: Context):LoginStorage {
    override val defaultValue= ""

    private val userPreferences: SharedPreferences = context.getSharedPreferences("USERS_TABLE",Context.MODE_PRIVATE)
    private val tokenPreferences: SharedPreferences =
        context.getSharedPreferences("TOKEN_TABLE", Context.MODE_PRIVATE)


    override fun saveUserName(userName: String) {
        val editor = userPreferences.edit()
        editor?.putString("name",userName)
        editor?.apply()
    }
    override fun saveUserLogged(bool: Boolean) {
        val editor = userPreferences.edit()
        editor?.putBoolean("isLogged",bool)
        editor?.apply()
    }
    override fun saveId(id: String?) {
        val editor = userPreferences.edit()
        editor?.putString("id", id.toString())
        editor?.apply()
    }


    override fun saveAccessToken(token: String) {
        val editor = tokenPreferences.edit()
        editor?.putString("accessToken",token)
        editor?.apply()
    }

    override fun saveRefreshToken(token: String) {
        val editor = tokenPreferences.edit()
        editor?.putString("refreshToken",token)
        editor?.apply()
    }

    override fun getId(): String?= userPreferences.getString("id",defaultValue)
}