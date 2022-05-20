package com.newcore.movieapptask.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Videos(
    @SerializedName("results")
    var results: List<Result>
)