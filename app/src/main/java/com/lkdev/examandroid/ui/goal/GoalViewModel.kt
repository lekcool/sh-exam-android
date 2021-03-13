package com.lkdev.examandroid.ui.goal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lkdev.examandroid.data.Goal
import com.lkdev.examandroid.data.Type

class GoalViewModel : ViewModel() {

    private val _typeLiveData = MutableLiveData(Goal.TYPE_LIST_MOCK)
    val typeLiveData: LiveData<List<Type>> get() = _typeLiveData
}