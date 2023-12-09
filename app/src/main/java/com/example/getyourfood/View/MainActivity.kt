package com.example.getyourfood.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.getyourfood.R
import com.example.getyourfood.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

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