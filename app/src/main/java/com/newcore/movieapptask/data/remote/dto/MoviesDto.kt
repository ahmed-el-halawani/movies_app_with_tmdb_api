package com.newcore.movieapptask.data.remote.dto


import com.google.gson.annotations.SerializedName

data class MoviesDto(
    @SerializedName("page")
    var page: Int,
    @SerializedName("results")
    var results: List<MovieDto>,
    @SerializedName("total_pages")
    var totalPages: Int,
    @SerializedName("total_results")
    var totalResults: Int
)