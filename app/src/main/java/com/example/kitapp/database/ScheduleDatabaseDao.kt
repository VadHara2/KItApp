package com.example.kitapp.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ScheduleDatabaseDao {
    @Insert
    fun insert(night: ScheduleItem)

    @Update
    fun update(night: ScheduleItem)

    @Query("SELECT * from schedule_item_table WHERE dayId = :key")
    fun get(key: Long): ScheduleItem?

    @Query("DELETE FROM schedule_item_table")
    fun clear()

    @Query("SELECT * FROM schedule_item_table ORDER BY dayId DESC")
    fun getAllDays(): LiveData<List<ScheduleItem>>

    @Query("SELECT * FROM schedule_item_table ORDER BY dayId DESC LIMIT 1")
    suspend fun getDay(): ScheduleItem?

}