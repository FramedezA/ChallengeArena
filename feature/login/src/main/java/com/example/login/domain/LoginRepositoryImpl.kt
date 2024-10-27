package com.example.login.domain

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.login.data.LoginStorage
import com.example.login.data.data_structures.LoginRequest
import com.example.login.data.data_structures.LoginResponse
import com.example.login.data.retrofit.Interface.LoginRetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response as RetrofitResponse

class LoginRepositoryImpl(private val retrofitService: LoginRetrofitService,
                          private val storage: LoginStorage):LoginRepository {
    override fun login(
        login: String, password: String,
        userIsLoggedMutableLiveData: MutableLiveData<Boolean>
    ) {
        retrofitService.login(LoginRequest(login, password))
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: RetrofitResponse<LoginResponse>
                ) {
                    Log.d("mLogResponse", call.request().toString())

                    if (response.isSuccessful) {
                        Log.d("mLogSucc", response.body().toString())
                        storage.saveAccessToken(response.body()!!.accessToken)
                        storage.saveRefreshToken(response.body()!!.refreshToken)
                        storage.saveUserName(response.body()!!.userName)
                        storage.saveId(response.body()!!.id.toString())
                        userIsLoggedMutableLiveData.value = true
                        storage.saveUserLogged(true)

                    }
                    else{
                        Log.d("mLogSuccERR", response.toString())
                        Log.d("mLogSuccERR2", call.request().toString())


                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.d("mLogERR", t.message.toString())
                }
            })
    }
}