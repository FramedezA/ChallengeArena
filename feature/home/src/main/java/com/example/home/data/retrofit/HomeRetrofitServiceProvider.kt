package com.example.home.data.retrofit

import com.example.home.data.retrofit.Interface.HomeRetrofitService
import com.example.network.RetrofitClient


object HomeRetrofitServiceProvider {
    val homeRetrofitService: HomeRetrofitService by lazy {
        RetrofitClient.getClient().create(HomeRetrofitService::class.java)
    }

}