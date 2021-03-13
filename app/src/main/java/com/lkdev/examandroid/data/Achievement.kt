package com.lkdev.examandroid.data

import androidx.recyclerview.widget.DiffUtil
import com.lkdev.examandroid.R

data class Achievement(
    val id: Int,
    val name: String,
    val icon: Int
) {
    companion object {
        val LIST_MOCK = createMock()

        private fun createMock(): List<Achievement> {
            val list = arrayListOf<Achievement>()
            for (i in 1..8) {
                list.add(Achievement(i, "Achievement", R.drawable.ic_achievement))
            }
            return list
        }

        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Achievement?>() {
            override fun areItemsTheSame(oldItem: Achievement, newItem: Achievement): Boolean {
                return oldItem.id == newItem.id
                        && oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Achievement, newItem: Achievement): Boolean {
                return oldItem == newItem
            }
        }
    }
}
