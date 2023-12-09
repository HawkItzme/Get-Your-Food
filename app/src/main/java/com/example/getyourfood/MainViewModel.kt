package com.example.getyourfood

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.getyourfood.model.Business
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {
    private val _pizzaList = MutableLiveData<List<Business>>()
    val pizzaList: LiveData<List<Business>> get() = _pizzaList

    private val _juiceList = MutableLiveData<List<Business>>()
    val juiceList: LiveData<List<Business>> get() = _juiceList

    val apiService = RetrofitClient.createService(YelpApiService::class.java)
    val repository = YelpRepository(apiService)
    fun searchPizza(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            try {
                val response = repository.searchBusinesses("pizza", latitude, longitude)
                if (response.isSuccessful) {
                    _pizzaList.value = response.body()?.businesses
                    Log.d("Checkyy", _pizzaList.value.toString())
                } else {
                    Log.d("Checkyy", "Error: ${response.code()}")
                    // Handle specific HTTP error codes if needed
                }
            } catch (e: Exception) {
                Log.e("Checkyy", "Exception: ${e.message}", e)
                // Handle the exception, for example, network issues or parsing errors
            }
        }
    }

    fun searchJuice(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            try {
                val response = repository.searchBusinesses("juice", latitude, longitude)
                if (response.isSuccessful) {
                    _juiceList.value = response.body()?.businesses
                } else {
                    Log.d("Checkyy", "Error: ${response.code()}")
                    // Handle error
                }
            } catch (e: Exception) {
                Log.e("Checkyy", "Exception: ${e.message}", e)
                // Handle the exception, for example, network issues or parsing errors
            }
        }
    }
}