package com.lkdev.examandroid.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lkdev.examandroid.data.Banner
import com.lkdev.examandroid.data.Goal

class HomeViewModel : ViewModel() {

    private val _goalLiveData = MutableLiveData(Goal.LIST_MOCK)
    val goalLiveData: LiveData<List<Goal>> get() = _goalLiveData

    private val _bannerLiveData = MutableLiveData(Banner.LIST_MOCK)
    val bannerLiveData: LiveData<List<Banner>> get() = _bannerLiveData
}