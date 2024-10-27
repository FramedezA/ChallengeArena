package com.example.network.domain

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.network.data.TokenStorage
import com.example.network.data.data_structures.RefreshResponse
import com.example.network.data.retrofit.Interface.NetworkRetrofitService
import com.example.network.presentation.NetworkServiceLocator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TokenRepositoryImpl(private val retrofitService: NetworkRetrofitService,private val storage:TokenStorage):TokenRepository {
    override fun refreshTokens(){
        retrofitService.refresh(storage.getToken()!!)
            .enqueue(object : Callback<RefreshResponse> {
                override fun onResponse(
                    call: Call<RefreshResponse>,
                    response: Response<RefreshResponse>
                ) {
                    Log.d("mLogResponse", call.request().toString())

                    if (response.isSuccessful) {
                        Log.d("mLogSucc", response.body().toString())

//                        refreshResponseMutableLiveData.value = response.body()
                        Log.d("mLogToken",response.body()!!.accessToken)
                        Log.d("mLogToken2",response.body()!!.refreshToken)
                         storage.setToken(response.body()!!.accessToken)
                        storage.setRefreshToken(response.body()!!.refreshToken)

//                        storage.saveAccessToken(response.body()!!.accessToken)
//                        storage.saveAccessToken(response.body()!!.refreshToken)
//                        userIsLoggedMutableLiveData.value = true
//                        storage.saveUserLogged(true)

                    }
                    else{
                        Log.d("mLogSuccERR", response.toString())
                        Log.d("mLogSuccERR2", call.request().toString())
//                        if (response.code() == 401 && "Invalid JWT token" in response.body().toString() ){
//
//                        }
                          storage.clearToken()
                          storage.clearUserData()


                    }
                }

                override fun onFailure(call: Call<RefreshResponse>, t: Throwable) {
                    Log.d("mLogERR", t.message.toString())
                }
            })
    }

    override fun getToken(): String? =
        storage.getToken()


    override fun setToken(token: String) {
        storage.setToken(token)
    }

    override fun clearToken() {
        storage.clearToken()
    }
}
