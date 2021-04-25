package com.astrateam.network.apinasagov.dao

import com.google.gson.annotations.SerializedName

data class WeatherNumericParamDao(
    @SerializedName("av")
    var av: Float,

    @SerializedName("ct")
    var ct: Int,

    @SerializedName("mn")
    var mn: Float,

    @SerializedName("mx")
    var mx: Float
)
