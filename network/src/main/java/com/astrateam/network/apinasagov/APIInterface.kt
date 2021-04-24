package com.astrateam.network.apinasagov

import com.astrateam.network.apinasagov.dao.MarsWeatherDao
import com.astrateam.network.apinasagov.dao.PictureDao
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("/planetary/apod")
    fun getPictureWithKey(
        @Query("api_key") apiKey: String
    ): Call<PictureDao>

    @GET("/insight_weather/")
    fun getMarsWeather(
        @Query("api_key") apiKey: String,
        @Query("feedtype") feedType: String,
        @Query("ver") version: String
    ): Call<MarsWeatherDao>
}
