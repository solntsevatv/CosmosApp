package com.astrateam.database

import android.net.Uri
import com.astrateam.database.model.MarsDayWeather
import com.astrateam.database.model.MarsPhoto
import com.astrateam.database.model.MediaAsset
import com.astrateam.database.model.Picture
import com.astrateam.network.NetworkHandler
import java.text.SimpleDateFormat
import java.util.*


object NetworkRepository : ModelRepository {
    override suspend fun getPicture(day: Date): Picture {
        val pictureDao = NetworkHandler.getPicture()

        return Picture(Uri.parse(pictureDao.url))
    }

    override suspend fun getMarsWeather(day: Date): MarsDayWeather {
        val marsWeatherDao = NetworkHandler.getMarsWeather()
        val marsDayWeatherDao = marsWeatherDao.sols.values.last()

        return MarsDayWeather().apply {
            date = day
            marsDayWeatherDao.temperature?.let {
                temperature = it.av
            }
            marsDayWeatherDao.pressure?.let {
                pressure = it.av
            }
        }
    }

    override suspend fun getMediaAssets(
        day: Date,
        count: Int,
        query: String,
        imageOnly: Boolean
    ): List<MediaAsset> {
        val mediaAssetsListDao = NetworkHandler.getMediaAssetsList(query)

        return mediaAssetsListDao.items.take(count).map {
            MediaAsset(it.data[0].title, it.data[0].description)
        }
    }

    override suspend fun getMarsPhotos(day: Date): List<MarsPhoto> {
        val dateString = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(day)
        val marsPhotosListDao = NetworkHandler.getMarsPhotosList(dateString)

        return marsPhotosListDao.photos.map {
            MarsPhoto().apply {
                earthDate = day
                url = it.imageSrc
                camera = when (it.camera.name) {
                    "RHAZ" -> MarsPhoto.CameraType.RHAZ
                    "MAST" -> MarsPhoto.CameraType.MAST
                    "CHEMCAM" -> MarsPhoto.CameraType.CHEMCAM
                    "FHAZ" -> MarsPhoto.CameraType.FHAZ
                    "MAHLI" -> MarsPhoto.CameraType.MAHLI
                    "MARDI" -> MarsPhoto.CameraType.MARDI
                    "MINITES" -> MarsPhoto.CameraType.MINITES
                    "NAVCAM" -> MarsPhoto.CameraType.NAVCAM
                    "PANCAM" -> MarsPhoto.CameraType.PANCAM
                    else -> MarsPhoto.CameraType.UNKNOWN
                }
            }
        }
    }
}
