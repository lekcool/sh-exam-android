package com.lkdev.examandroid.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lkdev.examandroid.R
import com.lkdev.examandroid.data.Goal
import com.lkdev.examandroid.data.Status
import com.lkdev.examandroid.data.Type
import kotlinx.android.synthetic.main.item_goal.view.*
import java.util.*

class GoalAdapter : ListAdapter<Goal, GoalViewHolder>(Goal.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_goal, parent, false)
        return GoalViewHolder(view)
    }

    override fun onBindViewHolder(holder: GoalViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class GoalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @SuppressLint("DefaultLocale")
    fun bind(item: Goal) {
        itemView.detailText.text = item.detail
        itemView.goalText.text = item.getGoalFormat()
        itemView.currentGoalText.text = item.getCurrentGoalFormat()
        itemView.statusText.text = item.status.name.toLowerCase().capitalize()
        itemView.dateText.text = item.date

        itemView.progressBar.apply {
            max = item.goal
            progress = item.currentGoal
        }

        itemView.goalImage.setImageResource(getIcon(item.type))
        itemView.statusText.setTextColor(getColor(item.status))
        itemView.goalLayout.setBackgroundResource(getBg(item.status))
    }

    private fun getIcon(type: Type): Int {
        return when (type) {
            Type.TRAVEL -> R.drawable.ic_travel
            Type.EDUCATION -> R.drawable.ic_education
            Type.INVEST -> R.drawable.ic_invest
            Type.CLOTHING -> R.drawable.ic_clothing
        }
    }

    private fun getColor(status: Status): Int {
        return ContextCompat.getColor(
            itemView.context, when (status) {
                Status.GOOD -> R.color.good
                Status.UNHAPPY -> R.color.unhappy
            }
        )
    }

    private fun getBg(status: Status): Int {
        return when (status) {
            Status.GOOD -> R.drawable.bg_border_corner_green
            Status.UNHAPPY -> R.drawable.bg_border_corner_red
        }
    }
}