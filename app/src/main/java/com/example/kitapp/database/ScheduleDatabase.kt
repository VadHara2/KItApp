package com.example.kitapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ScheduleItem::class], version = 4, exportSchema = false)
abstract class ScheduleDatabase : RoomDatabase() {

    abstract val scheduleDatabaseDao: ScheduleDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: ScheduleDatabase? = null

        fun getInstance(context: Context): ScheduleDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ScheduleDatabase::class.java,
                        "schedule_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}