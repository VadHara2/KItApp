package com.example.kitapp.startingpage

import android.app.Application
import android.content.Intent.getIntent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.kitapp.R
import com.example.kitapp.database.ScheduleDatabase
import com.example.kitapp.database.ScheduleDatabaseDao
import com.example.kitapp.database.ScheduleItem
import com.example.kitapp.databinding.StartFramentBinding
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_item_view.view.*


class StartFragment(var chth:Boolean): Fragment() {
    lateinit var binding: StartFramentBinding
    lateinit var application: Application
    lateinit var dataSource: ScheduleDatabaseDao
    lateinit var viewModelFactory: StartViewModelFactory
    lateinit var startViewModel: StartViewModel
    lateinit var adapter: ScheduleAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.start_frament, container, false)
        application = requireNotNull(this.activity).application
        dataSource = ScheduleDatabase.getInstance(application).scheduleDatabaseDao
        viewModelFactory = StartViewModelFactory(dataSource, application)
        startViewModel = ViewModelProvider(this, viewModelFactory).get(StartViewModel::class.java)
        binding.lifecycleOwner = this
        adapter = ScheduleAdapter()
        binding.scheduleList.adapter = adapter

        if (chth){
            startViewModel.createDayOfSchedule()
        }


        fun updateData(newData:List<ScheduleItem>){
            if (adapter.data != newData.filter { it.whichDay == chth }) {
                adapter.data = newData.filter { it.whichDay == chth }
            }
        }

        startViewModel.days.observe(viewLifecycleOwner, Observer {
            it?.let {
                updateData(it)
            }
        })


        return binding.root
    }

}