package com.example.network.data
import android.content.Context
import android.content.SharedPreferences

class TokenStorageImpl(context: Context) : TokenStorage {
    override val defaultValue: String = "qq"


    private val preferences: SharedPreferences =
        context.getSharedPreferences("TOKEN_TABLE", Context.MODE_PRIVATE)
    private val userPreferences =context.getSharedPreferences("USERS_TABLE",Context.MODE_PRIVATE)

    override fun setToken(token: String) {
        val editor = preferences.edit()
        editor?.putString("accessToken",token)
        editor?.apply()
    }

    override fun getToken(): String? = preferences.getString("accessToken",defaultValue)
//    override fun getToken(): String? = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJiIiwiaWQiOjEzLCJyb2xlcyI6WyJST0xFX1VTRVIiXSwiZXhwIjoxNzI5ODQ4Mjc3fQ.0LMmWOOhrF5T9HWcrrfZezbqV3C2E1yj2pnY9LVcaSkKdC4qqDR0h6r_MfvOr7E3"

    override fun clearToken() {
        val editor = preferences.edit()
        editor?.clear()
        editor?.apply()
    }

    override fun setRefreshToken(token: String) {
        val editor = preferences.edit()
        editor?.putString("refreshToken",token)
        editor?.apply()
    }

    override fun getRefreshToken(): String? =preferences.getString("refreshToken",defaultValue)


    override fun clearUserData() {
        val editor = userPreferences.edit()
        editor?.clear()
        editor?.apply()
    }
}
