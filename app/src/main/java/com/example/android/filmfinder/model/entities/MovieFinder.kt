package com.example.android.filmfinder.model.entities

data class MovieFinder(
    val movie: Film = getDefaultMovie(),
    val plot: String = "This is a description of the movie"
)

fun getDefaultMovie() = Film(
    "Squid Game",
    2021,
    5.5,
    "https://images.freeimages.com/images/large-previews/241/night-fog-1521028.jpg"
)
