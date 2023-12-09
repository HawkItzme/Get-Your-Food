package com.example.getyourfood.data.remote

import com.example.getyourfood.data.model.BusinessResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YelpApiService {
    @GET("transactions/delivery/search")
    suspend fun searchBusinesses(
        @Query("term") term: String,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double
    ): Response<BusinessResponse>
}