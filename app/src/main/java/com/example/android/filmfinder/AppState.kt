package com.example.android.filmfinder

import com.example.android.filmfinder.model.entities.MovieFinder

sealed class AppState {
    data class Success(val movieData: List<MovieFinder>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}