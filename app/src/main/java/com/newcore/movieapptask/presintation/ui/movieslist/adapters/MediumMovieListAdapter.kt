package com.newcore.movieapptask.presintation.ui.movieslist.adapters

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.newcore.movieapptask.databinding.ItemMediumSlideBinding
import com.newcore.movieapptask.domain.model.Movie

class MediumMovieListAdapter : BaseMovieListAdapter<MediumMovieListAdapter.MovieListViewHolder>() {

    open class MovieListViewHolder(private val binding: ItemMediumSlideBinding) :
        RecyclerView.ViewHolder(binding.root) {
        operator fun invoke(movie: Movie) = binding.apply {
            Glide.with(binding.root.context)
                .load("https://image.tmdb.org/t/p/w500" +
                        movie.run { posterPath ?: backdropPath }
                ).listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean,
                    ): Boolean {
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean,
                    ): Boolean {
                        pbLading.isVisible = false
                        return false
                    }
                })

                .into(ivImage)
            title.text = movie.title
            description.text = movie.overview
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        return MovieListViewHolder(ItemMediumSlideBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        ))
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder(movies[position])
    }

    override fun getItemCount() = movies.size

}