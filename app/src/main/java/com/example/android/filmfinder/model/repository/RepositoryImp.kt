package com.example.android.filmfinder.model.repository

import com.example.android.filmfinder.model.FilmLoader
import com.example.android.filmfinder.model.entities.MovieFinder
import com.example.android.filmfinder.model.entities.getTopMovies

class RepositoryImp : Repository {

    override fun getMoviesFromServer(id: String): MovieFinder {
        val dto = FilmLoader.loadFilm(id)
        return MovieFinder(
            title = dto?.title,
            year = dto?.year ?: 0,
            rating = dto?.rating ?: 0.0,
            plot = dto?.plot
        )
    }

    override fun getMoviesFromLocalStorage() = getTopMovies()
}