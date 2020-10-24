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

    fun createDayOfSchedule() {



        viewModelScope.launch {
            if (database.getDay() == null){
                Log.i("lol5","${database.getDay()}")
                var newDay = ScheduleItem()
                insert(newDay)
                newDay = database.getDay()!!
                var day = newDay ?: return@launch
                day.nameDay = "Субота"
                day.whichDay = true
                day.firstLesson = "-"
                day.secondLesson = "-"
                day.thirdLesson = "-"
                day.fourthLesson = "Алгоритми 2209 пр."
                day.fifthLesson = "Програмування 2209 пр."
                day.sixthLesson = "Програмування 2113 лек."
                day.seventhLesson = "-"
                subDay(day)
                update(day)

                newDay = ScheduleItem()
                insert(newDay)
                newDay = database.getDay()!!
                day = newDay ?: return@launch
                day.nameDay = "Субота"
                day.whichDay = false
                day.firstLesson = "-"
                day.secondLesson = "-"
                day.thirdLesson = "-"
                day.fourthLesson = "-"
                day.fifthLesson = "Мат. Аналіз 2308 лек."
                day.sixthLesson = "Алгоритми 2112 лек."
                day.seventhLesson = "-"
                subDay(day)
                update(day)

                newDay = ScheduleItem()
                insert(newDay)
                newDay = database.getDay()!!
                day = newDay ?: return@launch
                day.nameDay = "П'ятниця"
                day.whichDay = true
                day.firstLesson = "-"
                day.secondLesson = "-"
                day.thirdLesson = "ТІМС 2309 лек."
                day.fourthLesson = "ТІМС 2309 пр."
                day.fifthLesson = "Англійська 2208 пр."
                day.sixthLesson = "-"
                day.seventhLesson = "-"
                subDay(day)
                update(day)

                newDay = ScheduleItem()
                insert(newDay)
                newDay = database.getDay()!!
                day = newDay ?: return@launch
                day.nameDay = "П'ятниця"
                day.whichDay = false
                day.firstLesson = "-"
                day.secondLesson = "-"
                day.thirdLesson = "-"
                day.fourthLesson = "-"
                day.fifthLesson = "Електорадіо. 2309 лек."
                day.sixthLesson = "Електорадіо. 2311 пр."
                day.seventhLesson = "Фізкультура"
                subDay(day)
                update(day)

                newDay = ScheduleItem()
                insert(newDay)
                newDay = database.getDay()!!
                day = newDay ?: return@launch
                day.nameDay = "Четвер"
                day.whichDay = true
                day.firstLesson = "-"
                day.secondLesson = "-"
                day.thirdLesson = "-"
                day.fourthLesson = "-"
                day.fifthLesson = "Мат. Аналіз 2308 лек."
                day.sixthLesson = "ОБД 2112 лек."
                day.seventhLesson = "-"
                subDay(day)
                update(day)

                newDay = ScheduleItem()
                insert(newDay)
                newDay = database.getDay()!!
                day = newDay ?: return@launch
                day.nameDay = "Четвер"
                day.whichDay = false
                day.firstLesson = "-"
                day.secondLesson = "-"
                day.thirdLesson = "-"
                day.fourthLesson = "-"
                day.fifthLesson = "Мат. Аналіз 2308 лек."
                day.sixthLesson = "Алгоритми 2112 лек."
                day.seventhLesson = "-"
                subDay(day)
                update(day)

                newDay = ScheduleItem()
                insert(newDay)
                newDay = database.getDay()!!
                day = newDay ?: return@launch
                day.nameDay = "Середа"
                day.whichDay = true
                day.firstLesson = "-"
                day.secondLesson = "-"
                day.thirdLesson = "-"
                day.fourthLesson = "-"
                day.fifthLesson = "Електорадіо. 2309 лек."
                day.sixthLesson = "Електорадіо. 2309 лек."
                day.seventhLesson = "Фізкультура"
                subDay(day)
                update(day)

                newDay = ScheduleItem()
                insert(newDay)
                newDay = database.getDay()!!
                day = newDay ?: return@launch
                day.nameDay = "Середа"
                day.whichDay = false
                day.firstLesson = "-"
                day.secondLesson = "-"
                day.thirdLesson = "-"
                day.fourthLesson = "-"
                day.fifthLesson = "Електорадіо. 2309 лек."
                day.sixthLesson = "Електорадіо. 2311 пр."
                day.seventhLesson = "Фізкультура"
                subDay(day)
                update(day)

                newDay = ScheduleItem()
                insert(newDay)
                newDay = database.getDay()!!
                day = newDay ?: return@launch
                day.nameDay = "Вівторок"
                day.whichDay = true
                day.firstLesson = "-"
                day.secondLesson = "-"
                day.thirdLesson = "-"
                day.fourthLesson = "Алгоритми 2209 пр."
                day.fifthLesson = "Програмування 2209 пр."
                day.sixthLesson = "Програмування 2113 лек."
                day.seventhLesson = "-"
                subDay(day)
                update(day)

                newDay = ScheduleItem()
                insert(newDay)
                newDay = database.getDay()!!
                day = newDay ?: return@launch
                day.nameDay = "Вівторок"
                day.whichDay = false
                day.firstLesson = "-"
                day.secondLesson = "-"
                day.thirdLesson = "-"
                day.fourthLesson = "Алгоритми 2209 пр."
                day.fifthLesson = "ОБД 2113 пр."
                day.sixthLesson = "Системне ПЗ 2113 лек."
                day.seventhLesson = "Системне ПЗ 2113 пр."
                subDay(day)
                update(day)

                newDay = ScheduleItem()
                insert(newDay)
                newDay = database.getDay()!!
                day = newDay ?: return@launch
                day.nameDay = "Понеділок"
                day.whichDay = true
                day.firstLesson = "-"
                day.secondLesson = "-"
                day.thirdLesson = "ТІМС 2309 лек."
                day.fourthLesson = "ТІМС 2309 пр."
                day.fifthLesson = "Англійська 2208 пр."
                day.sixthLesson = "-"
                day.seventhLesson = "-"
                subDay(day)
                update(day)

                newDay = ScheduleItem()
                insert(newDay)
                newDay = database.getDay()!!
                day = newDay ?: return@launch
                day.nameDay = "Понеділок"
                day.whichDay = false
                day.firstLesson = "-"
                day.secondLesson = "-"
                day.thirdLesson = "ТІМС 2309 лек."
                day.fourthLesson = "Мат. Аналіз 2310 пр."
                day.fifthLesson = "Англійська 2208 пр."
                day.sixthLesson = "-"
                day.seventhLesson = "-"
                subDay(day)
                update(day)
            }else{
                    viewModelJob.cancel()
            }
        }
    }

    private fun subDay(day2:ScheduleItem){
       // if (day2.whichDay){

            days.value?.plus(day2)
      //  }
//        else{
//            Log.i("lol","${day2.whichDay.toString()}")
//            downList.value?.plus(day2)
//        }
    }

//    fun sendUpList(){
//        for (item in upList){
//            when(item.whichDay){
//                true -> days.value?.plus(item)
//
//            }
////            days.value?.plus(item)
//        }
//
//    }
//
//    fun sendDownList(){
//        for (item in downList){
//            days.value?.plus(item)
//        }
//    }

    fun onClear() {
        viewModelScope.launch {
            // Clear the database table.
            clear()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()

    }

}