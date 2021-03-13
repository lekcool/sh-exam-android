package com.lkdev.examandroid.ui.achievement

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lkdev.examandroid.data.AchievementInfo

class AchievementViewModel : ViewModel() {

    private val _achievementInfoLiveData = MutableLiveData(AchievementInfo.MOCK)
    val achievementInfoLiveData: LiveData<AchievementInfo> get() = _achievementInfoLiveData
}