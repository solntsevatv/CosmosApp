package com.astrateam.network

import com.astrateam.network.apinasagov.dao.MarsWeatherDao
import com.astrateam.network.apinasagov.dao.PictureDao
import com.astrateam.network.imagesnasagov.dao.MediaAssetsListDao
import retrofit2.Call
import com.astrateam.network.apinasagov.APIHandler.Companion as APIHandler_API
import com.astrateam.network.imagesnasagov.APIHandler.Companion as APIHandler_MEDIA


class NetworkHandler private constructor() {
    companion object {
        fun getPicture(): Call<PictureDao> {
            return APIHandler_API.instance.getPicture()
        }

        fun getMarsWeather(): Call<MarsWeatherDao> {
            return APIHandler_API.instance.getMarsWeather()
        }

        fun getMediaAssetsList(query: String): Call<MediaAssetsListDao> {
            return APIHandler_MEDIA.instance.getMediaAssetsList(query)
        }
    }
}
