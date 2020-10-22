package com.example.kitapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "schedule_item_table")
data class ScheduleItem(
    @PrimaryKey(autoGenerate = false)
    var nameDayId: String = "Понеділок/ч",

    @ColumnInfo(name = "first_lesson")
    val firstLesson: String = "",

    @ColumnInfo(name = "second_lesson")
    val secondLesson: String= "",

    @ColumnInfo(name = "third_lesson")
    val thirdLesson: String = "ТІМС",

    @ColumnInfo(name = "fourth_lesson")
    val fourthLesson: String = "ТІМС",

    @ColumnInfo(name = "fifth_lesson")
    val fifthLesson: String = "ТІМС",
)