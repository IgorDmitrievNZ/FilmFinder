package com.example.android.filmfinder.model.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    val id: String,
    val poster: String
) : Parcelable

fun getDefaultMovie() = Film(
    "tt1375666",
    "https://images.freeimages.com/images/large-previews/241/night-fog-1521028.jpg"
)

fun getTopMovies() = listOf(
    MovieFinder(Film("tt1375666", "poster"), "Inception", 2010, 8.8, "description"),
    MovieFinder(Film("tt0109830", "poster"), "Forrest Gump", 1994, 8.8, "description")

)
