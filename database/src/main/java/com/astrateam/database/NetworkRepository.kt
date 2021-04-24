package com.astrateam.database

import android.net.Uri
import com.astrateam.database.model.MarsDayWeather
import com.astrateam.database.model.MediaAsset
import com.astrateam.database.model.Picture
import com.astrateam.network.NetworkHandler
import java.util.*


object NetworkRepository : ModelRepository {
    override suspend fun getPicture(day: Date): Picture {
        val pictureDao = NetworkHandler.getPicture()

        return Picture(Uri.parse(pictureDao.url))
    }

    override suspend fun getMarsWeather(day: Date): MarsDayWeather {
        val marsWeatherDao = NetworkHandler.getMarsWeather()
        val temperature = marsWeatherDao.sols.values.random().temperature?.av ?: -1.0f
        val pressure = marsWeatherDao.sols.values.random().pressure?.av ?: -1.0f

        return MarsDayWeather(day, temperature, pressure)
    }

    override suspend fun getMediaAssets(day: Date, count: Int, query: String, imageOnly: Boolean): List<MediaAsset> {
        val mediaAssetsListDao = NetworkHandler.getMediaAssetsList(query)

        return mediaAssetsListDao.items.take(count).map {
            MediaAsset(it.data[0].title, it.data[0].description)
        }
    }
}
