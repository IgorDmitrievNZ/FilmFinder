package com.example.android.filmfinder.model.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    val title: String,
    val yearProduce: Int,
    val rating: Double = 0.0,
    val poster: String
):Parcelable
