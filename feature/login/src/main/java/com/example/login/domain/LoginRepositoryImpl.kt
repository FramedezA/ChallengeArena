package com.example.login.domain

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.core.data_structures.Response
import com.example.login.data.LoginStorage
import com.example.login.data.data_structures.UserInfo
import com.example.login.data.retrofit.Interface.LoginRetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response as RetrofitResponse

class LoginRepositoryImpl(private val retrofitService: LoginRetrofitService,
                          private val storage: LoginStorage):LoginRepository {
    override fun loginUser(
        login: String,
        password: String,
        loginCodeMutableLiveData: MutableLiveData<UserInfo>
    ) {
        retrofitService.loginUser(login, password).enqueue(object : Callback<Response<UserInfo>> {
            override fun onResponse(call: Call<Response<UserInfo>>, response: RetrofitResponse<Response<UserInfo>>) {
                if (response.isSuccessful) {
                    loginCodeMutableLiveData.value = response.body()!!.data
                    if (loginCodeMutableLiveData.value?.loginStatusCode == 0) {
                        loginCodeMutableLiveData.value.let {
                            storage.saveUserLogged(true)
                            storage.saveId(it!!.userId.toString())
                            storage.saveUserName(it.userName)
                        }
                    }
                }
            }
            override fun onFailure(call: Call<Response<UserInfo>>, t: Throwable) {
                Log.d("mLogERR", "$t   $call")
            }
        })
    }
}