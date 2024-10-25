package com.example.auth.data.retrofit

import com.example.auth.data.retrofit.Interface.AuthRetrofitService
import com.example.network.RetrofitClient


object RetrofitServiceProvider {
    val authRetrofitService: AuthRetrofitService by lazy {
        RetrofitClient.getClient().create(AuthRetrofitService::class.java)
    }

}