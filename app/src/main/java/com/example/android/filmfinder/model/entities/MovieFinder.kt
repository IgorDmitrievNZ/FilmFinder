package com.example.android.filmfinder.model.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieFinder(
    val movie: Film = getDefaultMovie(),
    val title: String? = "No title",
    val year: Int,
    val rating: Double = 0.0,
    val plot: String? = "This is a description of the movie"
) : Parcelable

