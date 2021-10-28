package com.example.android.filmfinder.model.repository

import com.example.android.filmfinder.model.entities.MovieFinder
import com.example.android.filmfinder.model.entities.getTopMovies
import com.example.android.filmfinder.model.rest.FilmRepo

class RepositoryImp : Repository {

    override fun getMoviesFromServer(id: String): MovieFinder {
        val dto = FilmRepo.api.getMovie(id).execute().body()
        return MovieFinder(
            title = dto?.title,
            year = dto?.year ?: 0,
            rating = dto?.rating ?: 0.0,
            poster = dto?.poster,
            plot = dto?.plot
        )
    }

    override fun getMoviesFromLocalStorage() = getTopMovies()
}