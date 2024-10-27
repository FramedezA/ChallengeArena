package com.example.achievements.domain

import androidx.lifecycle.MutableLiveData
import com.example.achievements.data.data_structures.Achievement

interface AchievementsRepository {
    fun getAchievments(achievementsMutableLiveData:MutableLiveData<List<Achievement>>)
}