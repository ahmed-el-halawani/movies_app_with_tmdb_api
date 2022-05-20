package com.newcore.movieapptask.domain.usecases

import com.newcore.movieapptask.common.Resources
import com.newcore.movieapptask.data.remote.dto.toMovie
import com.newcore.movieapptask.domain.repository.IMovieRepo
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

enum class MoviesLanguageEnum(val query: String) {
    Arabic("ar"), English("en"), Korean("ko"), Japanese("ja")
}

class GetMoviesWithUseCase @Inject constructor(private val movieRepo: IMovieRepo) {
    operator fun invoke(
        page: Int,
        moviesLanguage: MoviesLanguageEnum = MoviesLanguageEnum.English,
    ) = flow {
        try {
            emit(Resources.Loading())

            emit(Resources.Success(
                movieRepo.getMoviesWith(page, moviesLanguage.query).results.map {
                    it.toMovie()
                }
            ))
        } catch (io: IOException) {
            emit(Resources.Error("please check internet connection  $io"))
        } catch (e: Exception) {
            emit(Resources.Error("un expected error  $e"))
        }
    }
}
