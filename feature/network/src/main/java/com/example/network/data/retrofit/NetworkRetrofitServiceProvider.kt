package com.example.network.data.retrofit

import com.example.network.data.retrofit.Interface.NetworkRetrofitService
import com.example.network.RetrofitClient


object NetworkRetrofitServiceProvider {
    val networkRetrofitService: NetworkRetrofitService by lazy {
        RetrofitClient.getClient().create(NetworkRetrofitService::class.java)
    }

}