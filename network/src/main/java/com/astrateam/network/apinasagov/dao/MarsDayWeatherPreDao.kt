package com.astrateam.network.apinasagov.dao

import com.google.gson.annotations.SerializedName

data class MarsDayWeatherPreDao(
    @SerializedName("av")
    var av: String?,

    @SerializedName("ct")
    var ct: String?,

    @SerializedName("mn")
    var mn: String?,

    @SerializedName("mx")
    var mx: String?
)
