package com.astrateam.network

import com.astrateam.network.apinasagov.dao.MarsWeatherDao
import com.astrateam.network.apinasagov.dao.PictureDao
import com.astrateam.network.imagesnasagov.dao.MediaAssetsListDao
import com.astrateam.network.apinasagov.APIHandler.Companion as APIHandler_API
import com.astrateam.network.imagesnasagov.APIHandler.Companion as APIHandler_MEDIA


class NetworkHandler private constructor() {
    companion object {
        suspend fun getPicture(): PictureDao {
            return APIHandler_API.instance.getPicture()
        }

        suspend fun getMarsWeather(): MarsWeatherDao {
            return APIHandler_API.instance.getMarsWeather()
        }

        suspend fun getMediaAssetsList(query: String): MediaAssetsListDao {
            return APIHandler_MEDIA.instance.getMediaAssetsList(query)
        }
    }
}
