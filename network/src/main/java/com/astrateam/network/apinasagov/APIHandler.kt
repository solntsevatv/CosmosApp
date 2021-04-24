package com.astrateam.network.apinasagov

import com.astrateam.network.API_KEY
import com.astrateam.network.apinasagov.dao.MarsWeatherDao
import com.astrateam.network.apinasagov.dao.MarsWeatherDeserializer
import com.astrateam.network.apinasagov.dao.PictureDao
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIHandler private constructor() {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().registerTypeAdapter(
                    object : TypeToken<MarsWeatherDao>() {}.type, MarsWeatherDeserializer()
                )
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .setLenient()
                    .create()
            )
        )
        .build()
    private val apiInterface: APIInterface = retrofit.create(APIInterface::class.java)

    companion object {
        private const val BASE_URL = "https://api.nasa.gov"

        @get:Synchronized
        val instance: APIHandler by lazy { APIHandler() }
    }

    suspend fun getPicture(): PictureDao {
        return apiInterface.getPictureWithKey(API_KEY)
    }

    suspend fun getMarsWeather(): MarsWeatherDao {
        return apiInterface.getMarsWeather(API_KEY, "json", "1.0")
    }
}
