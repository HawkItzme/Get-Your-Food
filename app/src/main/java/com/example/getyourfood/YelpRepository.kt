package com.example.getyourfood

import com.example.getyourfood.model.BusinessResponse
import retrofit2.Response

class YelpRepository(private val apiService: YelpApiService) {
    suspend fun searchBusinesses(term: String, latitude: Double, longitude: Double): Response<BusinessResponse> {
        return apiService.searchBusinesses(term, latitude, longitude)
    }
}