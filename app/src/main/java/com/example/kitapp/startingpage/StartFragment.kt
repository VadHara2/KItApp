package com.example.kitapp.startingpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kitapp.R
import com.example.kitapp.database.ScheduleDatabase
import com.example.kitapp.database.ScheduleDatabaseDao
import com.example.kitapp.databinding.StartFramentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class StartFragment: Fragment() {

    private lateinit var viewModel: StartViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: StartFramentBinding = DataBindingUtil.inflate(inflater, R.layout.start_frament, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = ScheduleDatabase.getInstance(application).scheduleDatabaseDao
        val viewModelFactory = StartViewModelFactory(dataSource, application)
        val startViewModel = ViewModelProvider(this, viewModelFactory).get(StartViewModel::class.java)

        binding.startViewModel = startViewModel
        binding.lifecycleOwner = this

        val adapter = ScheduleAdapter()
        binding.scheduleList.adapter = adapter
        adapter.data = listOf("Понеділок", "Вівторок")






        return binding.root
    }
}