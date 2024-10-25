package com.example.network.di

import android.content.Context
import com.example.network.AuthInterceptor
import com.example.network.TokenManager
import com.example.network.TokenStorage
import com.example.network.TokenStorageImpl

import dagger.Module
import dagger.Provides

@Module
class NetworkModule {
    @Provides
    fun provideTokenStorage(context: Context): TokenStorage = TokenStorageImpl(context)

//    @Provides
//    fun provideTokenManager(tokenStorage: TokenStorage): TokenManager = TokenManager(tokenStorage)

}