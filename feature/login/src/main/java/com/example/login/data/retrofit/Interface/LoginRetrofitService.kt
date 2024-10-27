package com.example.login.data.retrofit.Interface

import com.example.core.data_structures.Response
import com.example.login.data.data_structures.LoginRequest
import com.example.login.data.data_structures.LoginResponse
import com.example.login.data.data_structures.UserInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface LoginRetrofitService {

    @POST("/api/v1/auth/login")
    fun login(
        @Body loginRequest: LoginRequest
    ):Call<LoginResponse>
}