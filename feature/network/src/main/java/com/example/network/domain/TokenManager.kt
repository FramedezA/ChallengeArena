package com.example.network.domain

import androidx.lifecycle.ViewModelProvider


class TokenManager(private val repository: TokenRepository) {


    fun getToken(): String? {
        return repository.getToken()
//        return tokenViewModel.getToken()
//        return "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJiIiwiaWQiOjEzLCJyb2xlcyI6WyJST0xFX1VTRVIiXSwiZXhwIjoxNzI5ODQ4Mjc3fQ.0LMmWOOhrF5T9HWcrrfZezbqV3C2E1yj2pnY9LVcaSkKdC4qqDR0h6r_MfvOr7E3"
    }


    fun saveToken(token: String) {
//        tokenViewModel.setToken(token)
        repository.setToken(token)
    }



    fun clearToken() {
//        tokenViewModel.clearToken()
        repository.clearToken()
    }


    fun isTokenValid(): Boolean {
        val token = getToken() ?: return false
        return token.isNotEmpty()
    }


    fun refreshToken() {

        // Предполагается, что у вас есть API для обновления токена
        // Здесь должен быть код для вызова API и обновления токена
        return try {
//            tokenViewModel.refreshToken()
//            tokenViewModel.refreshResponse.observeForever {
//                saveToken(it.accessToken)
//            }
             repository.refreshTokens()
            // Пример: вызов API для обновления токена


        } catch (_: Exception) {

        }
    }
}
