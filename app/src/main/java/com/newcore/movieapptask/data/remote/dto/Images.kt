package com.newcore.movieapptask.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("backdrops")
    var backdrops: List<Backdrop>,
    @SerializedName("logos")
    var logos: List<Logo>,
    @SerializedName("posters")
    var posters: List<Poster>
)