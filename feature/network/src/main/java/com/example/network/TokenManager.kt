package com.example.network


class TokenManager(private val tokenStorage: TokenStorage) {


    fun getToken(): String? {
        return tokenStorage.getToken()
//        return "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJiIiwiaWQiOjEzLCJyb2xlcyI6WyJST0xFX1VTRVIiXSwiZXhwIjoxNzI5ODQ4Mjc3fQ.0LMmWOOhrF5T9HWcrrfZezbqV3C2E1yj2pnY9LVcaSkKdC4qqDR0h6r_MfvOr7E3"
    }


    fun saveToken(token: String) {
        tokenStorage.setToken(token)
    }


    fun clearToken() {
        tokenStorage.clearToken()
    }


    fun isTokenValid(): Boolean {
        val token = getToken() ?: return false
        return token.isNotEmpty()
    }


    fun refreshToken(): Result<String> {
        // Предполагается, что у вас есть API для обновления токена
        // Здесь должен быть код для вызова API и обновления токена
        return try {
            // Пример: вызов API для обновления токена
            val newToken = "new_jwt_token_from_api"
            saveToken(newToken)
            Result.success(newToken)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
