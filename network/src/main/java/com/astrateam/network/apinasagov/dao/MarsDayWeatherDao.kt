package com.astrateam.network.apinasagov.dao

import com.google.gson.annotations.SerializedName

data class MarsDayWeatherDao(
    @SerializedName("First_UTC")
    var firstUTC: String?,

    @SerializedName("Last_UTC")
    var lastUTC: String?,

    @SerializedName("Season")
    var season: String?,

    @SerializedName("Northern_season")
    var northernSeason: String?,

    @SerializedName("Southern_season")
    var southernSeason: String?,

    @SerializedName("Month_ordinal")
    var month: Int?,

    @SerializedName("AT")
    var temperature: WeatherNumericParamDao?,

    @SerializedName("PRE")
    var pressure: WeatherNumericParamDao?,

    @SerializedName("HWS")
    var windSpeed: WeatherNumericParamDao?
)
