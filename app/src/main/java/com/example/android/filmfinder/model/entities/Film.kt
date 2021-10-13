package com.example.android.filmfinder.model.entities

data class Film(
    val title: String,
    val yearProduce: Int,
    val rating: Double = 0.0,
    val poster: String
)
