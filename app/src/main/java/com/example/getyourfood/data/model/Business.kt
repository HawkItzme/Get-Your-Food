package com.example.getyourfood.data.model

data class Business(
    val categories: List<Category>,
    val coordinates: Coordinates,
    val id: String,
    val image_url: String,
    val location: Location,
    val name: String,
    val phone: String,
    val price: String,
    val rating: Double,
    val review_count: Int,
    val url: String
)