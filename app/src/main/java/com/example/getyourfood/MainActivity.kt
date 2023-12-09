package com.example.getyourfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getyourfood.databinding.ActivityMainBinding
import com.example.getyourfood.model.Business
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewpager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(binding.tablayout , binding.viewpager) { tab, position ->
            tab.text = when (position) {
                0 -> "Pizza"
                1 -> "Juice"
                else -> ""
            }
        }.attach()
    }
}