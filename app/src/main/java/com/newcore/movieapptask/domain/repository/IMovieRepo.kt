package com.newcore.movieapptask.domain.repository

import com.newcore.movieapptask.data.remote.dto.MovieDetailsDto
import com.newcore.movieapptask.data.remote.dto.MoviesDto

interface IMovieRepo {
    suspend fun getTrendingMovies(page: Int): MoviesDto

    suspend fun getMoviesWith(page: Int, language: String): MoviesDto

    suspend fun getMovie(id: String): MovieDetailsDto
}