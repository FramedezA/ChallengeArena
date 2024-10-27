package com.example.network.domain

import androidx.lifecycle.MutableLiveData
import com.example.network.data.data_structures.RefreshResponse

interface TokenRepository {
    fun refreshTokens()
    fun getToken():String?
    fun setToken(token:String)
    fun clearToken()



}