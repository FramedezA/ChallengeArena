package com.example.achievements.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.achievements.data.data_structures.Achievement
import com.example.achievements.domain.AchievementsRepository
import kotlinx.coroutines.launch

class AchievementsViewModel(private val repository: AchievementsRepository): ViewModel() {


    private val achievementsMutableLiveData :MutableLiveData<List<Achievement>> = MutableLiveData()
    val achievements:LiveData<List<Achievement>> = achievementsMutableLiveData


    fun getAchievments(){
        viewModelScope.launch {
            repository.getAchievments(achievementsMutableLiveData)
        }
    }



}
class AchievementsViewModelFactory(private val achievementsRepository: AchievementsRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        AchievementsViewModel(achievementsRepository) as T
}