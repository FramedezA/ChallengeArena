package com.example.network.presentation

import android.util.Log
import com.example.network.domain.TokenGetterManager
import com.example.network.domain.TokenManager
import okhttp3.Interceptor
import okhttp3.Response


class AuthInterceptor : Interceptor {

    private val tokenManager =
        NetworkServiceLocator.getService<TokenGetterManager>("TokenGetterManager")!!

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
            .header("Authorization", "Bearer ${tokenManager.getToken()}")
//            .header("Content-Type","application/json")
            .build()
        Log.d("mLogTT",tokenManager.getToken().toString())
        return chain.proceed(newRequest)
    }
}