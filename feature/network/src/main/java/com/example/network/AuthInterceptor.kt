package com.example.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


class AuthInterceptor : Interceptor {

//    @Inject
    var tokenManager: TokenManager = TokenManager()

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
            .header("Authorization", "Bearer ${tokenManager.getToken()}")
            .build()
        return chain.proceed(newRequest)
    }
}