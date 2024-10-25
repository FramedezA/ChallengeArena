package com.example.network
import android.content.Context
import android.content.SharedPreferences

class TokenStorageImpl(context: Context) : TokenStorage {
    override val defaultValue: String
        get() = ""

    private val preferences: SharedPreferences =
        context.getSharedPreferences("TOKEN_TABLE", Context.MODE_PRIVATE)

    override fun setToken(token: String) {
        val editor = preferences.edit()
        editor?.putString("token",token)
        editor?.apply()
    }

//    override fun getToken(): String? = preferences.getString("token",defaultValue)
    override fun getToken(): String? = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJiIiwiaWQiOjEzLCJyb2xlcyI6WyJST0xFX1VTRVIiXSwiZXhwIjoxNzI5ODQ4Mjc3fQ.0LMmWOOhrF5T9HWcrrfZezbqV3C2E1yj2pnY9LVcaSkKdC4qqDR0h6r_MfvOr7E3"

    override fun clearToken() {
        val editor = preferences.edit()
        editor?.clear()
        editor?.apply()
    }
}
