package com.example.android.filmfinder.model.rest_entities

data class FilmDTO(
    val title: String,
    val year: Int,
    val rating: Double,
    val poster: String?,
    val plot: String?
)
