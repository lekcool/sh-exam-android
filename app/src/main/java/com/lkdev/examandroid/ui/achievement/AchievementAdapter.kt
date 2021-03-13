package com.lkdev.examandroid.ui.achievement

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lkdev.examandroid.R
import com.lkdev.examandroid.data.Achievement
import kotlinx.android.synthetic.main.item_achievement.view.*

class AchievementAdapter : ListAdapter<Achievement, AchievementViewHolder>(Achievement.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_achievement, parent, false)
        return AchievementViewHolder(view)
    }

    override fun onBindViewHolder(holder: AchievementViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class AchievementViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Achievement) {
        itemView.achievementText.text = item.name
        itemView.achievementImage.setImageResource(item.icon)
    }
}