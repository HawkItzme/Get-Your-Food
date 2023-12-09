package com.example.getyourfood.data

import com.example.getyourfood.data.model.BusinessResponse
import com.example.getyourfood.data.remote.YelpApiService
import retrofit2.Response

class YelpRepository(private val apiService: YelpApiService) {
    suspend fun searchBusinesses(term: String, latitude: Double, longitude: Double): Response<BusinessResponse> {
        return apiService.searchBusinesses(term, latitude, longitude)
    }
}