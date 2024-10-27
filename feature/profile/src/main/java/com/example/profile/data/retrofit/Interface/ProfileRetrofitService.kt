package com.example.profile.data.retrofit.Interface

import com.example.profile.data.data_structures.Profile
import com.example.profile.data.data_structures.ProfileRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface ProfileRetrofitService {

    @GET("/api/v1/users/{id}")
    fun getProfile(
        @Path("id") id:String
    ): Call<Profile>

    @POST("/api/v1/users/edit/{id}")
    fun setProfile(
        @Path("id") id:String,
        @Body profileRequest: ProfileRequest
    ):Call<Profile>

//    @POST("/api/v1/auth/register")
//    fun regNewUser(
//        @Body registerRequest: RegisterRequest
//    ): Call<AuthResponse>
//
//    @POST("/api/v1/auth/login")
//    fun login(
//        @Body loginRequest: LoginRequest
//    ):Call<LoginResponse>
//
//    @GET("/api/v1/users/{id}")
//    fun getUser(
//        @Path("id") id: Int,
//
//    ):Call<Any>
}