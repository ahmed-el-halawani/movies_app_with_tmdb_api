package com.newcore.movieapptask.domain.model

data class Movie(
    var id: Int? = null,
    var backdropPath: String? = null,
    var genreIds: List<Int>? = null,
    var originalLanguage: String? = null,
    var originalTitle: String? = null,
    var overview: String? = null,
    var posterPath: String? = null,
    var releaseDate: String? = null,
    var title: String? = null,
    var voteAverage: Double? = null,
    var voteCount: Int? = null,
)
