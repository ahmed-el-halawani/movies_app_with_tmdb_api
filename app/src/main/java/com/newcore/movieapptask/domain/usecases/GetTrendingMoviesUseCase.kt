package com.newcore.movieapptask.domain.usecases

import com.newcore.movieapptask.common.Resources
import com.newcore.movieapptask.data.remote.dto.toMovie
import com.newcore.movieapptask.domain.repository.IMovieRepo
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetTrendingMoviesUseCase @Inject constructor(private val movieRepo: IMovieRepo) {
    operator fun invoke(page: Int) = flow {
        try {
            emit(Resources.Loading())

            emit(Resources.Success(
                movieRepo.getTrendingMovies(page).results.map {
                    it.toMovie()
                }
            ))
        } catch (io: IOException) {
            emit(Resources.Error("please check internet connection"))
        } catch (e: Exception) {
            emit(Resources.Error("un expected error"))
        }
    }
}
