package com.example.kitapp

import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.BoringLayout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.kitapp.database.ScheduleDatabase
import com.example.kitapp.databinding.ActivityMainBinding
import com.example.kitapp.databinding.StartFramentBinding
import com.example.kitapp.startingpage.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_item_view.*
import kotlinx.android.synthetic.main.start_frament.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setUpTabs(false)

    }


    fun setUpTabs(isBlack:Boolean){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(StartFragment(true),"Чисельник")
        adapter.addFragment(StartFragment(false),"Знаменник")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.getTabAt(0)!!.setText("Чисельник")
        tabLayout.getTabAt(1)!!.setText("Знаменник")
//        tabLayout.getTabAt(2)!!.setText("Адмінка")

        //tabLayout.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_settings_24)
    }
}