package com.lkdev.examandroid.data

import androidx.recyclerview.widget.DiffUtil
import java.text.NumberFormat

data class Goal(
    val id: Int,
    val detail: String,
    val goal: Int,
    val currentGoal: Int,
    val status: Status,
    val type: Type,
    val date: String
) {
    fun getGoalFormat(): String {
        val format = NumberFormat.getInstance()
        return "${format.format(goal)} THB"
    }

    fun getCurrentGoalFormat(): String {
        val format = NumberFormat.getInstance()
        return "${format.format(currentGoal)} THB"
    }

    companion object {
        val LIST_MOCK = createMock()
        val TYPE_LIST_MOCK = createTypeMock()

        private fun createTypeMock(): List<Type> {
            val list = arrayListOf<Type>()
            list.add(Type.TRAVEL)
            list.add(Type.EDUCATION)
            list.add(Type.INVEST)
            list.add(Type.CLOTHING)
            list.add(Type.EDUCATION)
            return list
        }

        private fun createMock(): List<Goal> {
            val list = arrayListOf<Goal>()
            list.add(
                Goal(
                    id = 1,
                    detail = "ไปเที่ยวญี่ปุ่น",
                    goal = 20000,
                    currentGoal = 16500,
                    status = Status.GOOD,
                    type = Type.TRAVEL,
                    date = "45 Days left"
                )
            )

            list.add(
                Goal(
                    id = 2,
                    detail = "ซื้อกองทุนรวม",
                    goal = 6000,
                    currentGoal = 500,
                    status = Status.UNHAPPY,
                    type = Type.INVEST,
                    date = "20 Days left"
                )
            )

            list.add(
                Goal(
                    id = 1,
                    detail = "ไปทะเล",
                    goal = 10000,
                    currentGoal = 6500,
                    status = Status.GOOD,
                    type = Type.TRAVEL,
                    date = "10 Days left"
                )
            )
            return list
        }

        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Goal?>() {
            override fun areItemsTheSame(oldItem: Goal, newItem: Goal): Boolean {
                return oldItem.id == newItem.id
                        && oldItem.detail == newItem.detail
                        && oldItem.goal == newItem.goal
                        && oldItem.currentGoal == newItem.currentGoal
            }

            override fun areContentsTheSame(oldItem: Goal, newItem: Goal): Boolean {
                return oldItem == newItem
            }
        }

        val TYPE_DIFF_CALLBACK = object : DiffUtil.ItemCallback<Type?>() {
            override fun areItemsTheSame(oldItem: Type, newItem: Type): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Type, newItem: Type): Boolean {
                return oldItem == newItem
            }
        }
    }
}

enum class Type {
    TRAVEL, EDUCATION, INVEST, CLOTHING
}

enum class Status {
    GOOD, UNHAPPY
}