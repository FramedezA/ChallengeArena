package com.example.achievements.domain

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.achievements.data.AchievementsStorage
import com.example.achievements.data.data_structures.Achievement
import com.example.achievements.data.retrofit.Interface.AchievementsRetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AchievementsRepositoryImpl(
    private val retrofitService: AchievementsRetrofitService,
    private val storage: AchievementsStorage
) :
    AchievementsRepository {
    override fun getAchievments(achievementsMutableLiveData: MutableLiveData<List<Achievement>>)

     {
        retrofitService.getAchievement(storage.getId().toInt())
            .enqueue(object : Callback<List<Achievement>> {
                override fun onResponse(
                    call: Call<List<Achievement>>,
                    response: Response<List<Achievement>>
                ) {
                    Log.d("mLogResponse", call.request().toString())

                    if (response.isSuccessful) {
                        achievementsMutableLiveData.value = response.body()!!
                    } else {
                        Log.d("mLogSuccERR", response.toString())
                        Log.d("mLogSuccERR2", call.request().toString())


                    }
                }

                override fun onFailure(call: Call<List<Achievement>>, t: Throwable) {
                    Log.d("mLogERR", t.message.toString())
                }
            })

    }

}