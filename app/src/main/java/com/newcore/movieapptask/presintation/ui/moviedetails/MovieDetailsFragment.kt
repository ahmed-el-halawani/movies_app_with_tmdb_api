package com.newcore.movieapptask.presintation.ui.movieslist

import androidx.fragment.app.viewModels
import com.newcore.movieapptask.common.views.BaseFragment
import com.newcore.movieapptask.databinding.FragmentMovieDetailsBinding

class MovieDetailsFragment : BaseFragment<FragmentMovieDetailsBinding>
    (FragmentMovieDetailsBinding::inflate) {

    private val vm: MovieDetailsFragmentViewModel by viewModels()

}

