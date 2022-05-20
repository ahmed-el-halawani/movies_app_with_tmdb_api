package com.newcore.movieapptask.presintation.ui.moviedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.newcore.movieapptask.domain.usecases.GetMoviesWithUseCase
import com.newcore.movieapptask.domain.usecases.GetTrendingMoviesUseCase
import com.newcore.movieapptask.domain.usecases.MoviesLanguageEnum
import com.newcore.movieapptask.presintation.ui.movieslist.viewentities.MoviesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieListFragmentViewModel @Inject constructor(
    val getTrendingMoviesUseCase: GetTrendingMoviesUseCase,
    val getMoviesWithUseCase: GetMoviesWithUseCase,

    ) :
    ViewModel() {

    private val moviesState = MoviesState()
    private val moviesStateMutableLiveData = MutableLiveData(moviesState)
    val moviesStateLiveData: LiveData<MoviesState> = moviesStateMutableLiveData


    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.Main + job)

    init {
        getMovies()
    }

    private fun getMovies() {
        getTrendingMoviesUseCase(1).onEach {
            moviesStateMutableLiveData.value = moviesState.apply {
                trendingMovies = it
                topMovies = it
            }
        }.launchIn(scope)
        getMoviesWithUseCase(1, MoviesLanguageEnum.Arabic).onEach {
            println(it)
            moviesStateMutableLiveData.value = moviesState.apply {
                arabicMovies = it
            }
        }.launchIn(scope)

        getMoviesWithUseCase(1, MoviesLanguageEnum.English).onEach {
            moviesStateMutableLiveData.value = moviesState.apply {
                englishMovies = it
            }
        }.launchIn(scope)

        getMoviesWithUseCase(1, MoviesLanguageEnum.English).onEach {
            moviesStateMutableLiveData.value = moviesState.apply {
                englishMovies = it
            }
        }.launchIn(scope)

        getMoviesWithUseCase(1, MoviesLanguageEnum.Korean).onEach {
            moviesStateMutableLiveData.value = moviesState.apply {
                koreanMovies = it
            }
        }.launchIn(scope)

        getMoviesWithUseCase(1, MoviesLanguageEnum.Japanese).onEach {
            moviesStateMutableLiveData.value = moviesState.apply {
                japaneseMovies = it
            }
        }.launchIn(scope)
    }

}