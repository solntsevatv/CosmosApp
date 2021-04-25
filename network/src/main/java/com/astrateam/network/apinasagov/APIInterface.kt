package com.astrateam.network.apinasagov

import com.astrateam.network.apinasagov.dao.MarsPhotosListDao
import com.astrateam.network.apinasagov.dao.MarsWeatherDao
import com.astrateam.network.apinasagov.dao.PictureDao
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("/planetary/apod")
    suspend fun getPictureWithKey(
        @Query("api_key") apiKey: String
    ): PictureDao

    @GET("/insight_weather/")
    suspend fun getMarsWeather(
        @Query("api_key") apiKey: String,
        @Query("feedtype") feedType: String,
        @Query("ver") version: String
    ): MarsWeatherDao

    @GET("/mars-photos/api/v1/rovers/curiosity/photos")
    suspend fun getMarsPhotos(
        @Query("api_key") apiKey: String,
        @Query("earth_date") earthDate: String
    ): MarsPhotosListDao
}
