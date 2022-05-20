package com.newcore.movieapptask.domain.model

import com.newcore.movieapptask.data.remote.dto.Genre
import com.newcore.movieapptask.data.remote.dto.Images
import com.newcore.movieapptask.data.remote.dto.ProductionCountry
import com.newcore.movieapptask.data.remote.dto.Videos

data class MovieDetails(
    var id: Int,
    var adult: Boolean,
    var backdropPath: String,
    var genres: List<Genre>,
    var images: Images,
    var originalTitle: String,
    var overview: String,
    var posterPath: String,
    var productionCountries: List<ProductionCountry>,
    var releaseDate: String,
    var tagline: String,
    var title: String,
    var videos: Videos,
    var voteAverage: Double,
    var voteCount: Int,
)