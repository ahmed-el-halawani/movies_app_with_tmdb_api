package com.newcore.movieapptask.common


sealed class Resources<T>(val data: T? = null, val message: String? = null) {
    data class Success<T>(private val dat: T) : Resources<T>(dat)
    data class Error<T>(private val messag: String, private val dat: T? = null) : Resources<T>
        (dat, messag)

    data class Loading<T>(private val dat: T? = null) : Resources<T>(dat)
}