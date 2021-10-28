package com.example.android.filmfinder.model.rest

import com.example.android.filmfinder.model.rest_entities.FilmDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmAPI {

    @GET("{movie_id}")
    fun getMovie(
        @Path(value = "movie_id") MovieId: String,
    ): Call<FilmDTO>
}