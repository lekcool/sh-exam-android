package com.lkdev.examandroid.data

data class Goal(
    val id: Int,
    val detail: String,
    val status: Status,
    val type: Type,
    val date: String
)

enum class Type {
    TRAVEL, EDUCATION, INVEST, CLOTHING
}

enum class Status {
    GOOD, UNHAPPY
}