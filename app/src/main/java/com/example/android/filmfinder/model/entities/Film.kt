package com.example.android.filmfinder.model.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    val title: String,
    val yearProduce: Int,
    val rating: Double = 0.0,
    val poster: String
) : Parcelable

fun getDefaultMovie() = Film(
    "Squid Game",
    2021,
    5.5,
    "https://images.freeimages.com/images/large-previews/241/night-fog-1521028.jpg"
)

fun getTopMovies() = listOf(
    MovieFinder(Film("Avatar", 2009, 7.5, "poster"), "Amazing description"),
    MovieFinder(Film("Cricket", 2057, 9.9, "poster"), "Future movie"),
    MovieFinder(Film("Forest Gump", 1994, 8.5, "poster"), "Run forest run!"),
    MovieFinder(Film("Mentы", 2002, 1.4, "poster"), "rubbish"),
    MovieFinder(Film("Avatar", 2009, 7.5, "poster"), "Amazing description"),
    MovieFinder(Film("Cricket", 2057, 9.9, "poster"), "Future movie"),
    MovieFinder(Film("Forest Gump", 1994, 8.5, "poster"), "Run forest run!"),
    MovieFinder(Film("Mentы", 2002, 1.4, "poster"), "rubbish"),
    MovieFinder(Film("Avatar", 2009, 7.5, "poster"), "Amazing description"),
    MovieFinder(Film("Cricket", 2057, 9.9, "poster"), "Future movie"),
    MovieFinder(Film("Forest Gump", 1994, 8.5, "poster"), "Run forest run!"),
    MovieFinder(Film("Mentы", 2002, 1.4, "poster"), "rubbish"),
    MovieFinder(Film("Avatar", 2009, 7.5, "poster"), "Amazing description"),
    MovieFinder(Film("Cricket", 2057, 9.9, "poster"), "Future movie"),
    MovieFinder(Film("Forest Gump", 1994, 8.5, "poster"), "Run forest run!"),
    MovieFinder(Film("Mentы", 2002, 1.4, "poster"), "rubbish")
)
