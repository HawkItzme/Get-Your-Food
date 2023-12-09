package com.example.getyourfood.model

data class BusinessResponse(
    val businesses: List<Business>,
    val total: Int
)