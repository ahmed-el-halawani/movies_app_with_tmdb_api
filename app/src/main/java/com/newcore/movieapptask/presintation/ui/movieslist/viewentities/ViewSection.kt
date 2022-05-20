package com.newcore.movieapptask.presintation.ui.movieslist.viewentities

import com.newcore.movieapptask.common.Resources
import com.newcore.movieapptask.domain.model.Movie

data class ViewSection(
    val sectionTitle: String,
    val sectionList: Resources<List<Movie>>,
    val isBig: Boolean = false,
)