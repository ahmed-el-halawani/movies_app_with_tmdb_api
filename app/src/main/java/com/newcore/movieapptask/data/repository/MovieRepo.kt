package com.newcore.movieapptask.data.repository

import com.newcore.movieapptask.data.remote.TmdbApi
import com.newcore.movieapptask.data.remote.dto.MovieDetailsDto
import com.newcore.movieapptask.data.remote.dto.MoviesDto
import com.newcore.movieapptask.domain.repository.IMovieRepo
import javax.inject.Inject

class MovieRepo @Inject constructor(private val tmdbApi: TmdbApi) : IMovieRepo {

    override suspend fun getTrendingMovies(page: Int): MoviesDto {
        return tmdbApi.getTrendingMovies(page)
    }

    override suspend fun getMoviesWith(page: Int, language: String): MoviesDto {
        return tmdbApi.getMoviesWith(page, language)
    }

    override suspend fun getMovie(id: String): MovieDetailsDto = tmdbApi.getMovie(id)
}