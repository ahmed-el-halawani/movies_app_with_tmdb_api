package com.newcore.movieapptask.data.remote

import com.newcore.movieapptask.common.Constants.API_KEY
import com.newcore.movieapptask.data.remote.dto.MovieDetailsDto
import com.newcore.movieapptask.data.remote.dto.MoviesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApi {

    @GET("/3/trending/movie/week")
    suspend fun getTrendingMovies(
        @Query("page") page: Int = 1,
        @Query("api_key") api_key: String = API_KEY,
    ): MoviesDto

    @GET("/3/discover/movie")
    suspend fun getMoviesWith(
        @Query("page") page: Int = 1,
        @Query("with_original_language") language: String = "en",
        @Query("api_key") api_key: String = API_KEY,
    ): MoviesDto

    @GET("/3/movie/{movieId}")
    suspend fun getMovie(
        @Path("movieId") movieId: String,
        @Query("language") language: String = "ar",
        @Query("append_to_response") append_to_response: String = "videos,images",
        @Query("api_key") api_key: String = API_KEY,
    ): MovieDetailsDto
}