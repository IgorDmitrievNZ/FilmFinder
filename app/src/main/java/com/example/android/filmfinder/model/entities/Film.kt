package com.example.android.filmfinder.model.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    val id: String
) : Parcelable

fun getDefaultMovie() = Film("tt1375666")

fun getTopMovies() = listOf(
    MovieFinder(
        Film("tt1375666"),
        "Inception",
        2010,
        8.8,
        "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@.jpg"
    ),

    MovieFinder(
        Film("tt0109830"),
        "Forrest Gump",
        1994,
        8.8,
        "https://m.media-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@.jpg"
    ),

    MovieFinder(
        Film("tt0111161"),
        "The Shawshank Redemption",
        1994,
        9.3,
        "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg"
    ),

    MovieFinder(
        Film("tt0137523"),
        "Fight Club",
        1999,
        8.8,
        "https://m.media-amazon.com/images/M/MV5BMmEzNTkxYjQtZTc0MC00YTVjLTg5ZTEtZWMwOWVlYzY0NWIwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@.jpg"
    ),

    MovieFinder(
        Film("tt0120689"),
        "The Green Mile",
        1999,
        8.6,
        "https://m.media-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1_UX182_CR0,0,182,268_AL_.jpg"
    ),

    MovieFinder(
        Film("tt0133093"),
        "The Matrix",
        1999,
        8.7,
        "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@.jpg"
    ),

    )
