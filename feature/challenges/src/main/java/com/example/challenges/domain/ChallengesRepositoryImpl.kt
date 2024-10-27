package com.example.challenges.domain

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.challenges.data.ChallengesStorage
import com.example.challenges.data.ChallengesStorageImpl
import com.example.challenges.data.data_structures.Challenge
import com.example.challenges.data.data_structures.ChallengeRequest
import com.example.challenges.data.data_structures.DatesToChallenges
import com.example.challenges.data.retrofit.Interface.ChallengesRetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChallengesRepositoryImpl(
    private val retrofitService: ChallengesRetrofitService,
    private val storage: ChallengesStorage
) :
    ChallengesRepository {
    override fun getChallenges(
        date: String,
        challengesMutableLiveData: MutableLiveData<List<Challenge>>
    ) {
        retrofitService.getChallengesByDate(DatesToChallenges("$date 00:01", "$date 23:59"))
            .enqueue(object : Callback<List<Challenge>> {
                override fun onResponse(
                    call: Call<List<Challenge>>,
                    response: Response<List<Challenge>>
                ) {
                    Log.d("mLogResponse", call.request().toString())

                    if (response.isSuccessful) {
                        challengesMutableLiveData.value = response.body()!!
                    } else {
                        Log.d("mLogSuccERR", response.toString())
                        Log.d("mLogSuccERR2", call.request().toString())


                    }
                }

                override fun onFailure(call: Call<List<Challenge>>, t: Throwable) {
                    Log.d("mLogERR", t.message.toString())
                }
            })

    }

    override fun setChallenge(
        challengeId: Int,
        challengeRequestMutableLiveData: MutableLiveData<ChallengeRequest>
    ) {
        retrofitService.setChallenge(ChallengeRequest(challengeId,storage.getId().toInt()))
            .enqueue(object : Callback<ChallengeRequest> {
                override fun onResponse(
                    call: Call<ChallengeRequest>,
                    response: Response<ChallengeRequest>
                ) {
                    Log.d("mLogResponse", call.request().toString())

                    if (response.isSuccessful) {
                        challengeRequestMutableLiveData.value = response.body()!!
                    } else {
                        Log.d("mLogSuccERR", response.toString())
                        Log.d("mLogSuccERR2", call.request().toString())


                    }
                }

                override fun onFailure(call: Call<ChallengeRequest>, t: Throwable) {
                    Log.d("mLogERR", t.message.toString())
                }
            })

    }
}