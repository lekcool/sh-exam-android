package com.lkdev.examandroid.data

import com.lkdev.examandroid.R

data class AchievementInfo(
    val id: Int,
    val level: Int,
    val icon: Int,
    val achievements: List<Achievement>
) {
    companion object {
        val MOCK = AchievementInfo(
            id = 1,
            level = 2,
            icon = R.drawable.ic_outline_emoji_events,
            achievements = Achievement.LIST_MOCK
        )
    }
}
