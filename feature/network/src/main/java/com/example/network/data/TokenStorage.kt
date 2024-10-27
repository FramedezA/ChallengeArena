package com.example.network.data

interface TokenStorage {
    val defaultValue: String
    fun setToken(token: String)
    fun getToken(): String?
    fun clearToken()
    fun setRefreshToken(token: String)
    fun getRefreshToken(): String?

    fun clearUserData()
}