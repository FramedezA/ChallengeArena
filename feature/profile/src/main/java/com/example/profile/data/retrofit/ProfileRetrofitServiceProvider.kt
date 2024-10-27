package com.example.profile.data.retrofit

import com.example.profile.data.retrofit.Interface.ProfileRetrofitService
import com.example.network.RetrofitClient


object ProfileRetrofitServiceProvider {
    val profileRetrofitService: ProfileRetrofitService by lazy {
        RetrofitClient.getClient().create(ProfileRetrofitService::class.java)
    }

}