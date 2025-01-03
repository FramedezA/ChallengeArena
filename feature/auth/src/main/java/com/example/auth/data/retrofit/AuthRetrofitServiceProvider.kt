package com.example.auth.data.retrofit

import com.example.auth.data.retrofit.Interface.AuthRetrofitService
import com.example.network.RetrofitClient


object AuthRetrofitServiceProvider {
    val authRetrofitService: AuthRetrofitService by lazy {
        RetrofitClient.getClientWithoutInterceptor().create(AuthRetrofitService::class.java)
    }

}