package com.example.kitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.kitapp.database.ScheduleDatabase
import com.example.kitapp.databinding.StartFramentBinding
import com.example.kitapp.startingpage.StartFragment
import com.example.kitapp.startingpage.StartViewModel
import com.example.kitapp.startingpage.StartViewModelFactory
import com.example.kitapp.startingpage.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.start_frament.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpTabs()
    }
    fun setUpTabs(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(StartFragment(true),"Чисельник")
        Log.i("lol10","Чиселиник вижив")
        adapter.addFragment(StartFragment(false),"Знаменник")
        Log.i("lol10","Знаменник вижив")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.getTabAt(0)!!.setText("Чисельник")
        tabLayout.getTabAt(1)!!.setText("Знаменник")
    }
}