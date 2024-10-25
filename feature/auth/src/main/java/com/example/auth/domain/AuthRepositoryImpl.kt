package com.example.auth.domain

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.auth.data.AuthStorage
import com.example.auth.data.data_structures.LoginRequest
import com.example.auth.data.retrofit.Interface.AuthRetrofitService
import com.example.auth.data.data_structures.RegisterRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response as RetrofitResponse

class AuthRepositoryImpl(private val retrofitService: AuthRetrofitService,
                         private val storage: AuthStorage
): AuthRepository {


    override fun regNewUser(
        userName: String,
        login: String,
        password: String,
        confirmPassword:String,
        userIdMutableLiveData: MutableLiveData<Int>
    ) {

        retrofitService.regNewUser(RegisterRequest(userName,login,password,confirmPassword))
            .enqueue(object : Callback<Any> {
                override fun onResponse(call: Call<Any>, response: RetrofitResponse<Any>) {
                    if (response.isSuccessful) {
                        Log.d("mLogSucc",response.body().toString())
//                        userIdMutableLiveData.value = response.body()!!
//                        userIdMutableLiveData.value.let {
//                            if (it != null) {
//                                if (it > 0) {
//                                    storage.saveUserLogged(true)
//                                    storage.saveId(it.toString())
//                                    storage.saveUserName(userName)
//                                }
//                            }
//                        }
                    }
                }
                override fun onFailure(call: Call<Any>, t: Throwable) {
                    Log.d("mLogERR", t.message.toString())
                }
            })
    }

//    override fun login(login: String, password: String) {
//        retrofitService.login(LoginRequest(login,password))
//            .enqueue(object : Callback<Any> {
//                override fun onResponse(call: Call<Any>, response: RetrofitResponse<Any>) {
//                    if (response.isSuccessful) {
//                        Log.d("mLogSucc",response.body().toString())
////                        userIdMutableLiveData.value = response.body()!!
////                        userIdMutableLiveData.value.let {
////                            if (it != null) {
////                                if (it > 0) {
////                                    storage.saveUserLogged(true)
////                                    storage.saveId(it.toString())
////                                    storage.saveUserName(userName)
////                                }
////                            }
////                        }
//                    }
//                    else{
//                        Log.d("mLogSuccERR",response.body().toString())
//
//                    }
//                }
//                override fun onFailure(call: Call<Any>, t: Throwable) {
//                    Log.d("mLogERR", t.message.toString())
//                }
//            })
//    }
//
//    override fun getUser(id: Int) {
//        retrofitService.getUser(id)
//            .enqueue(object : Callback<Any> {
//                override fun onResponse(call: Call<Any>, response: RetrofitResponse<Any>) {
//                    if (response.isSuccessful) {
//                        Log.d("mLogSucc",response.body().toString())
////                        userIdMutableLiveData.value = response.body()!!
////                        userIdMutableLiveData.value.let {
////                            if (it != null) {
////                                if (it > 0) {
////                                    storage.saveUserLogged(true)
////                                    storage.saveId(it.toString())
////                                    storage.saveUserName(userName)
////                                }
////                            }
////                        }
//                    } else{
//                        Log.d("mLogSuccERR",response.body().toString())
//                        Log.d("mLogSuccERR",response.toString())
//
//                    }
//                }
//                override fun onFailure(call: Call<Any>, t: Throwable) {
//                    Log.d("mLogERR", t.message.toString())
//                }
//            })
//    }

}