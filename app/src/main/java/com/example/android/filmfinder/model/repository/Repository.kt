package com.example.android.filmfinder.model.repository

import com.example.android.filmfinder.model.entities.MovieFinder

interface Repository {

    fun getMoviesFromServer(id: String): MovieFinder
    fun getMoviesFromLocalStorage(): List<MovieFinder>
}