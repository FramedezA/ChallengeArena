package com.example.login.data.retrofit

import com.example.login.data.retrofit.Interface.LoginRetrofitService
import com.example.network.RetrofitClient


object RetrofitServiceProvider {
    val loginRetrofitService: LoginRetrofitService by lazy {
        RetrofitClient.getClient().create(LoginRetrofitService::class.java)
    }

}