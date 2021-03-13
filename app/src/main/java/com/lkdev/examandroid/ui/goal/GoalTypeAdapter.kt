package com.lkdev.examandroid.ui.goal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lkdev.examandroid.R
import com.lkdev.examandroid.data.Goal
import com.lkdev.examandroid.data.Type
import kotlinx.android.synthetic.main.item_goal_type.view.*
import java.util.*

class GoalTypeAdapter : ListAdapter<Type, GoalTypeViewHolder>(Goal.TYPE_DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalTypeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_goal_type, parent, false)
        return GoalTypeViewHolder(view)
    }

    override fun onBindViewHolder(holder: GoalTypeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class GoalTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Type) {
        itemView.titleText.text = item.name.capitalize(Locale.getDefault())
        itemView.goalTypeImage.setImageResource(getIcon(item))
    }

    private fun getIcon(type: Type): Int {
        return when (type) {
            Type.TRAVEL -> R.drawable.ic_outline_emoji_events
            Type.EDUCATION -> R.drawable.ic_outline_home
            Type.INVEST -> R.drawable.ic_outline_account_balance_wallet
            Type.CLOTHING -> R.drawable.ic_outline_account_circle
        }
    }
}