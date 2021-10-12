package com.example.android.filmfinder.model.repository

import com.example.android.filmfinder.model.entities.MovieFinder
import com.example.android.filmfinder.model.entities.getTopMovies

class RepositoryImp : Repository {

    override fun getMoviesFromServer() = MovieFinder()
    override fun getMoviesFromLocalStorage() = getTopMovies()
}