package com.example.auth.data.retrofit.Interface

import com.example.auth.data.data_structures.AuthResponse
import com.example.auth.data.data_structures.LoginRequest
import com.example.auth.data.data_structures.LoginResponse
import com.example.auth.data.data_structures.RegisterRequest
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path





interface AuthRetrofitService {

    @POST("/api/v1/auth/register")
    fun regNewUser(
        @Body registerRequest: RegisterRequest
    ): Call<AuthResponse>

    @POST("/api/v1/auth/login")
    fun login(
        @Body loginRequest: LoginRequest
    ):Call<LoginResponse>
//
//    @GET("/api/v1/users/{id}")
//    fun getUser(
//        @Path("id") id: Int,
//
//    ):Call<Any>
}