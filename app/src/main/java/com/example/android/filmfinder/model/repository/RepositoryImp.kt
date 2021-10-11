package com.example.android.filmfinder.model.repository

import com.example.android.filmfinder.model.entities.MovieFinder

class RepositoryImp : Repository {

    override fun getMoviesFromServer() = MovieFinder()
    override fun getMoviesFromLocalStorage() = MovieFinder()
}