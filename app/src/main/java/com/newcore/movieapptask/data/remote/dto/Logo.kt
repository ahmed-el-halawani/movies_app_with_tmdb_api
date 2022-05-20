package com.newcore.movieapptask.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Logo(
    @SerializedName("aspect_ratio")
    var aspectRatio: Double,
    @SerializedName("file_path")
    var filePath: String,
    @SerializedName("height")
    var height: Int,
    @SerializedName("iso_639_1")
    var iso6391: String,
    @SerializedName("vote_average")
    var voteAverage: Double,
    @SerializedName("vote_count")
    var voteCount: Int,
    @SerializedName("width")
    var width: Int
)