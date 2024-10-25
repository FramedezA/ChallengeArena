package com.example.network

interface TokenStorage {
    val defaultValue: String
    fun setToken(token: String)
    fun getToken(): String?
    fun clearToken()
}