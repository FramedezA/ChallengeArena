package com.example.login.data.retrofit

import com.example.login.data.retrofit.Interface.LoginRetrofitService
import com.example.login.presentation.LoginServiceLocator
import com.example.network.data.retrofit.Interface.NetworkRetrofitService
import com.example.network.RetrofitClient


object LoginRetrofitServiceProvider {
    val loginRetrofitService: LoginRetrofitService by lazy {
        RetrofitClient.getClientWithoutInterceptor().create(LoginRetrofitService::class.java)
    }

}