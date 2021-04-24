package com.astrateam.network.imagesnasagov

import com.astrateam.network.imagesnasagov.dao.MediaAssetDao
import com.astrateam.network.imagesnasagov.dao.MediaAssetsListDao
import com.astrateam.network.imagesnasagov.dao.MediaAssetsListDeserializer
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIHandler private constructor() {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder()
                    .registerTypeAdapter(
                        MediaAssetsListDao::class.java,
                        MediaAssetsListDeserializer()
                    )
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .setLenient()
                    .create()
            )
        )
        .build()
    private val apiInterface: APIInterface = retrofit.create(APIInterface::class.java)

    companion object {
        private const val BASE_URL = "https://images-api.nasa.gov"

        @get:Synchronized
        val instance: APIHandler by lazy { APIHandler() }
    }

    fun getMediaAssetsList(query: String): Call<MediaAssetsListDao> {
        return apiInterface.getMediaAssetsList(query)
    }
}
