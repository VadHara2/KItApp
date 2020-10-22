package com.example.kitapp.startingpage

import android.app.Application
import android.content.res.Resources
import android.text.Spanned
import android.util.Log
import androidx.lifecycle.*
import com.example.kitapp.database.ScheduleDatabaseDao
import com.example.kitapp.database.ScheduleItem
import kotlinx.coroutines.*

class StartViewModel (val database: ScheduleDatabaseDao, application: Application) : AndroidViewModel(application)  {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    var days = database.getAllDays()


   // val dayList = listOf<ScheduleItem>(database.getAllDays())


    init {

    }
//
//    private fun initializeDay() {
//        viewModelScope.launch {
//            days = database.getAllDays()
//        }
//    }


    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }

    private suspend fun update(day: ScheduleItem) {
        withContext(Dispatchers.IO) {
            database.update(day)
        }
    }

    private suspend fun insert(day: ScheduleItem) {
        withContext(Dispatchers.IO) {
            database.insert(day)
        }
    }

    fun createDayOfSchedule(){

        Log.i("lol","1")

        viewModelScope.launch {
            var newDay = ScheduleItem()

            insert(newDay)
            newDay = database.getDay()!!
            //tonight.value = getTonightFromDatabase()

            val day = newDay ?: return@launch
            day.nameDay = "Вівторок"
            day.fifthLesson ="F"
            day.secondLesson = "dnslcndks"
            day.thirdLesson = ",ds,cdl;"
            day.fourthLesson = "skdlmcd"
            day.firstLesson= "F"
            update(day)
            subDay(day)
        }
    }

    private fun subDay(day2:ScheduleItem){
        days.value?.plus(day2)
    }

}