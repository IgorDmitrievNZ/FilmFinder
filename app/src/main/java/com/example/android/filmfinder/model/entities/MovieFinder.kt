package com.example.android.filmfinder.model.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieFinder(
    val movie: Film = getDefaultMovie(),
    val plot: String = "This is a description of the movie"
) : Parcelable

