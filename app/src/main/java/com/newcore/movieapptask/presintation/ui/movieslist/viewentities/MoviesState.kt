package com.newcore.movieapptask.presintation.ui.movieslist.viewentities

import com.newcore.movieapptask.common.Resources
import com.newcore.movieapptask.domain.model.Movie

data class MoviesState(
    var trendingMovies: Resources<List<Movie>> = Resources.Loading(),
    var arabicMovies: Resources<List<Movie>> = Resources.Loading(),
    var englishMovies: Resources<List<Movie>> = Resources.Loading(),
    var topMovies: Resources<List<Movie>> = Resources.Loading(),
    var koreanMovies: Resources<List<Movie>> = Resources.Loading(),
    var japaneseMovies: Resources<List<Movie>> = Resources.Loading(),
)
