package com.example.network

import com.example.core.BuildConfig
import com.example.network.presentation.AuthInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    private var retrofit: Retrofit? = null
    private var retrofitWithoutInterceptor :Retrofit? = null
    private var okHttpClient: OkHttpClient? = null
    private const val baseUrl = BuildConfig.BACKEND_URL


    private val authInterceptor: AuthInterceptor = AuthInterceptor()

    fun getClient(): Retrofit {
        val gsonBuilder = GsonBuilder().setLenient().create()
        if (retrofit == null) {
            okHttpClient = OkHttpClient.Builder()
                .addInterceptor(authInterceptor)
                .build()

            retrofit =
                Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
                    .client(okHttpClient!!)
                    .build()

        }
        return retrofit!!
    }

    fun getClientWithoutInterceptor():Retrofit{
        val gsonBuilder = GsonBuilder().setLenient().create()
        if (retrofitWithoutInterceptor == null) {


            retrofitWithoutInterceptor =
                Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
                    .build()

        }
        return retrofitWithoutInterceptor!!
    }

}