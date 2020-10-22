package com.example.kitapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "schedule_item_table")
data class ScheduleItem(
    @PrimaryKey(autoGenerate = true)
    var dayId: Long = 0L,

    @ColumnInfo(name = "name_day")
    var nameDay: String = " ",

    @ColumnInfo(name = "first_lesson")
    var firstLesson: String = " ",

    @ColumnInfo(name = "second_lesson")
    var secondLesson: String= " ",

    @ColumnInfo(name = "third_lesson")
    var thirdLesson: String = " ",

    @ColumnInfo(name = "fourth_lesson")
    var fourthLesson: String = " ",

    @ColumnInfo(name = "fifth_lesson")
    var fifthLesson: String = " ",
)