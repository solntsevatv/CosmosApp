package com.astrateam.database

import com.astrateam.database.model.MarsDayWeather
import com.astrateam.database.model.MarsPhoto
import com.astrateam.database.model.MediaAsset
import com.astrateam.database.model.Picture
import java.util.*

interface ModelRepository {

    suspend fun getPicture(day: Date): Picture

    suspend fun getMarsWeather(day: Date): MarsDayWeather

    suspend fun getMediaAssets(day: Date, count: Int, query: String, imageOnly: Boolean):  List<MediaAsset>

    suspend fun getMarsPhotos(day: Date): List<MarsPhoto>
}
