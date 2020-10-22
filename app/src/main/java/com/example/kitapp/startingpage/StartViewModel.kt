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
    val days = MutableLiveData<ScheduleItem?>()


    init {
        //createDayOfSchedule()
        initializeDays()
    }

    private fun initializeDays() {
        viewModelScope.launch {
            days.value = getDayFromDatabase()
        }
    }

    private suspend fun getDayFromDatabase(): ScheduleItem? {
        //return withContext(Dispatchers.IO) {
        var day = database.getDay()
        return day
        //}
    }

    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }

    private suspend fun update(night: ScheduleItem) {
        withContext(Dispatchers.IO) {
            database.update(night)
        }
    }

    private suspend fun insert(night: ScheduleItem) {
        withContext(Dispatchers.IO) {
            database.insert(night)
        }
    }

    fun createDayOfSchedule(){


        viewModelScope.launch {
            val newDay = ScheduleItem()

            insert(newDay)

            //tonight.value = getTonightFromDatabase()

            val day = days.value ?: return@launch
            Log.i("lol","1")
            day.fifthLesson ="F"
            day.secondLesson = "dnslcndks"
            day.thirdLesson = ",ds,cdl;"
            day.fourthLesson = "skdlmcd"
            day.firstLesson= "F"
            update(day)


        }
    }

}