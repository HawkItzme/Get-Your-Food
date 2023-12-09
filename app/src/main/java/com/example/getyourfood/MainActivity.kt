package com.example.getyourfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getyourfood.databinding.ActivityMainBinding
import com.example.getyourfood.model.Business
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recycleView.layoutManager = LinearLayoutManager(this)

        val apiService = RetrofitClient.createService(YelpApiService::class.java)
        val repository = YelpRepository(apiService)
        viewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        viewModel.searchPizza(33.16017034638842, -96.68231175805475)
        viewModel.searchJuice(33.16017034638842, -96.68231175805475)


//        viewModel.pizzaList.observe(this, Observer { businesses ->
//            updateRecyclerView(businesses)
////            Log.d("Checkyy", businesses.toString())
////            binding.recycleView.adapter = BusinessAdapter(this
////            , businesses)
//        })

        viewModel.juiceList.observe(this, Observer { businesses ->
            updateRecyclerView(businesses)
        })

    }

    private fun updateRecyclerView(businesses: List<Business>?) {
        businesses?.let {
            val adapter = BusinessAdapter(this, it)
            binding.recycleView.adapter = adapter
        }
    }
}