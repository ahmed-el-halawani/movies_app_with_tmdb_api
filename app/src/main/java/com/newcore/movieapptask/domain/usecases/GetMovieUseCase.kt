package com.newcore.movieapptask.domain.usecases

import com.newcore.movieapptask.common.Resources
import com.newcore.movieapptask.data.remote.dto.toMovieDetails
import com.newcore.movieapptask.domain.repository.IMovieRepo
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val movieRepo: IMovieRepo) {
    operator fun invoke(movieId: String) = flow {
        try {
            emit(Resources.Loading())

            emit(Resources.Success(
                movieRepo.getMovie(movieId).toMovieDetails()
            ))
        } catch (io: IOException) {
            emit(Resources.Error("please check internet connection"))
        } catch (e: Exception) {
            emit(Resources.Error("un expected error"))
        }
    }


}