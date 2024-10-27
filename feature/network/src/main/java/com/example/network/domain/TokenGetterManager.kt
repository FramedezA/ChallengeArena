package com.example.network.domain

import com.example.network.data.TokenStorage

class TokenGetterManager(private val storage: TokenStorage) {
    fun getToken() = storage.getToken()
}