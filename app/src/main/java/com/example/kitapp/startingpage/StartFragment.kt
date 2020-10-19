package com.example.kitapp.startingpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.kitapp.R
import com.example.kitapp.databinding.StartFramentBinding

class StartFragment: Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: StartFramentBinding = DataBindingUtil.inflate(inflater, R.layout.start_frament, container, false)


        return binding.root
    }
}