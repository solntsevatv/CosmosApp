package com.astrateam.network.apinasagov.dao

data class MarsWeatherDao(
    var sols: Map<Integer, MarsDayWeatherDao>
)
