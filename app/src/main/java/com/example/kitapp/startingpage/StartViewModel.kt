package com.example.kitapp.startingpage

import android.app.Application
import androidx.lifecycle.*
import com.example.kitapp.database.ScheduleDatabaseDao
import com.example.kitapp.database.ScheduleItem
import kotlinx.coroutines.*

class StartViewModel (val database: ScheduleDatabaseDao, application: Application) : AndroidViewModel(application)  {

}