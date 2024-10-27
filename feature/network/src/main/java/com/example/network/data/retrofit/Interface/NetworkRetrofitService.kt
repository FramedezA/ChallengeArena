package com.example.network.data.retrofit.Interface

import com.example.network.data.data_structures.RefreshResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkRetrofitService {

    @POST("/api/v1/auth/refresh")
    fun refresh(
        @Body refreshToken :String
    ):Call<RefreshResponse>
}