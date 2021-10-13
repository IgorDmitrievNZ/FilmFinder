package com.example.android.filmfinder.model.repository

import com.example.android.filmfinder.model.entities.MovieFinder

interface Repository {

    fun getMoviesFromServer(): MovieFinder
    fun getMoviesFromLocalStorage(): MovieFinder
}