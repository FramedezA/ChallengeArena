package com.example.home.domain

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.home.data.HomeStorage
import com.example.home.data.data_structures.Challenge
import com.example.home.data.retrofit.Interface.HomeRetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepositoryImpl(private val retrofitService: HomeRetrofitService,private val storage: HomeStorage):HomeRepository {
    override fun getUserName(): String =storage.getUserName()
    override fun getChallenges(challengesMutableLiveData: MutableLiveData<List<Challenge>>) {
        retrofitService.getChallenges(storage.getId().toInt())
            .enqueue(object : Callback<List<Challenge>> {
                override fun onResponse(
                    call: Call<List<Challenge>>,
                    response: Response<List<Challenge>>
                ) {
                    Log.d("mLogResponse", call.request().toString())

                    if (response.isSuccessful) {
                        challengesMutableLiveData.value = response.body()!!
                        Log.d("mLogSucc", response.body().toString())
//                        storage.saveAccessToken(response.body()!!.accessToken)
//                        storage.saveRefreshToken(response.body()!!.refreshToken)
//                        storage.saveUserName(response.body()!!.userName)
//                        storage.saveId(response.body()!!.id.toString())
//                        userIsLoggedMutableLiveData.value = true
//                        storage.saveUserLogged(true)

                    }
                    else{
                        Log.d("mLogSuccERR", response.toString())
                        Log.d("mLogSuccERR2", call.request().toString())


                    }
                }

                override fun onFailure(call: Call<List<Challenge>>, t: Throwable) {
                    Log.d("mLogERR", t.message.toString())
                }
            })
    }
    }

