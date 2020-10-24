package com.example.kitapp.startingpage

import android.content.Intent.getIntent
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
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.start_frament.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class StartFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.activity?.setTitle("Розклад")
        val binding: StartFramentBinding = DataBindingUtil.inflate(inflater, R.layout.start_frament, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = ScheduleDatabase.getInstance(application).scheduleDatabaseDao
        val viewModelFactory = StartViewModelFactory(dataSource, application)
        val startViewModel = ViewModelProvider(this, viewModelFactory).get(StartViewModel::class.java)
        binding.startViewModel = startViewModel

        startViewModel.createDayOfSchedule()


        binding.lifecycleOwner = this
        val adapter = ScheduleAdapter()
        binding.scheduleList.adapter = adapter


        fun updateData(newData:List<ScheduleItem>){
            if (adapter.data != newData.filter { it.whichDay == startViewModel.filter.value }) {
                adapter.data = newData.filter { it.whichDay == startViewModel.filter.value }
            }
        }

        startViewModel.days.observe(viewLifecycleOwner, Observer {
            it?.let {
                updateData(it)
            }
        })



        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                startViewModel.days.value?.let { updateData(it) }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                startViewModel.filter.value = !startViewModel.filter.value!!
            }
        })






        return binding.root
    }

}