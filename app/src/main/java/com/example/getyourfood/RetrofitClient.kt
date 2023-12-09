package com.example.getyourfood

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.yelp.com/v3/"

    private val okHttpClient = OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
        val newRequest: Request = chain.request().newBuilder()
            .addHeader("accept", "application/json")
            .addHeader("Authorization", "Bearer 2ROaa2Rh9qu3WVTCms8FoVE4mSfHQHC7QJua95-kKT-PqzIlLSrs4tmHVdtdFw_66-JNfRiJmbCByHTvFNy5dQq-tpfS4FrPpupIzKlgELR3br-r5trpeFhrCRgwWnYx")
            .build()
        chain.proceed(newRequest)
    }).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> createService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }
}
