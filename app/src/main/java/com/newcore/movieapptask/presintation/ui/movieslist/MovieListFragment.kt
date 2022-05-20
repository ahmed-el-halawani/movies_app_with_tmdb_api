package com.newcore.movieapptask.presintation.ui.moviedetails

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.glide.slider.library.tricks.ViewPagerEx
import com.newcore.movieapptask.common.Resources
import com.newcore.movieapptask.common.views.BaseFragment
import com.newcore.movieapptask.common.views.CustomSlider
import com.newcore.movieapptask.databinding.FragmentMovieListBinding
import com.newcore.movieapptask.domain.model.Movie
import com.newcore.movieapptask.presintation.ui.movieslist.adapters.SectionAdapter
import com.newcore.movieapptask.presintation.ui.movieslist.viewentities.MoviesState
import com.newcore.movieapptask.presintation.ui.movieslist.viewentities.ViewSection
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieListFragment :
    BaseFragment<FragmentMovieListBinding>(FragmentMovieListBinding::inflate) {

    private val vm: MovieListFragmentViewModel by viewModels()

    private val sectionAdapter by lazy {
        SectionAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        sliderListener()


        vm.moviesStateLiveData.observe(viewLifecycleOwner) { it ->
            setupSections(it)

            when (it.topMovies) {
                is Resources.Success -> {
                    setupSlider(it.topMovies.data ?: emptyList())
                }
                is Resources.Error -> {
                    Toast.makeText(requireContext(), it.topMovies.message, Toast.LENGTH_LONG).show()
                }
                else -> {}
            }
        }

    }


    fun setupSections(moviesState: MoviesState) {
        sectionAdapter.sections = listOf(
            ViewSection(
                "Trending Movies",
                moviesState.trendingMovies,
                false
            ),
            ViewSection(
                "Arabic  Movies",
                moviesState.arabicMovies,
                true
            ),
            ViewSection(
                "English Movies",
                moviesState.englishMovies,
                false
            ),
            ViewSection(
                "Korean Movies",
                moviesState.koreanMovies,
                false
            ),
            ViewSection(
                "Japanese Movies",
                moviesState.japaneseMovies,
                false
            )
        )
    }


    fun setupSlider(moviesState: List<Movie>) = with(binding) {
        for (movie in moviesState) {
            val textSliderView = CustomSlider(requireContext())
            // initialize a SliderLayout
            textSliderView
                .setScaleType(ImageView.ScaleType.CENTER_CROP)
                .description(movie.title)
                .image(
                    "https://image.tmdb.org/t/p/original" +
                            (movie.posterPath ?: movie.backdropPath),
                )
                .setProgressBarVisible(true)

            //add your extra information
            textSliderView.bundle(Bundle())
            textSliderView.bundle.apply {
                putString("title", movie.title)
                putInt("id", movie.id ?: 0)
                putString("description", movie.overview)
            }
            slider.addSlider(textSliderView)
        }
    }

    fun setupRecycler() = with(binding) {
        rvSectionList.apply {
            adapter = sectionAdapter
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager
                    .VERTICAL,
                false,
            )
            isNestedScrollingEnabled = false
        }
    }

    fun sliderListener() = with(binding) {
        slider.addOnPageChangeListener(object : ViewPagerEx.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int,
            ) {
            }

            override fun onPageSelected(position: Int) {
                slider.currentSlider.bundle.apply {
                    tvTitle.text = getString("title")
                    tvDescription.text = getString("description")
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

}

