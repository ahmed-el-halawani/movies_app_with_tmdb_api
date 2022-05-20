package com.newcore.movieapptask.presintation.ui.movieslist.adapters

import androidx.recyclerview.widget.RecyclerView
import com.newcore.movieapptask.domain.model.Movie

abstract class BaseMovieListAdapter<T : RecyclerView.ViewHolder> : RecyclerView.Adapter<T>() {
    var movies: List<Movie> = emptyList()
        set(value) {
            field = value
            notifyItemRangeChanged(0, value.size)
        }
}