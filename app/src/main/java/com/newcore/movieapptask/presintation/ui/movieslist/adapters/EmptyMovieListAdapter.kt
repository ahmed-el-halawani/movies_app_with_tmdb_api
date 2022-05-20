package com.newcore.movieapptask.presintation.ui.movieslist.adapters

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView

class EmptyMovieListAdapter : BaseMovieListAdapter<EmptyMovieListAdapter.MovieListViewHolder>() {

    open class MovieListViewHolder(private val binding: FrameLayout) :
        RecyclerView.ViewHolder(binding) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        return MovieListViewHolder(FrameLayout(parent.context))
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {}

    override fun getItemCount() = movies.size
}