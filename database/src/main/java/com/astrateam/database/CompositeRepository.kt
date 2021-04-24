package com.astrateam.database

import com.astrateam.database.model.MarsDayWeather
import com.astrateam.database.model.MediaAsset
import com.astrateam.database.model.Picture
import java.util.*

object CompositeRepository : ModelRepository {
    override suspend fun getPicture(day: Date): Picture {
        return NetworkRepository.getPicture(day)
    }

    override suspend fun getMarsWeather(day: Date): MarsDayWeather {
        return NetworkRepository.getMarsWeather(day)
    }

    override suspend fun getMediaAssets(
        day: Date,
        count: Int,
        query: String,
        imageOnly: Boolean
    ): List<MediaAsset> {
        return NetworkRepository.getMediaAssets(day, count, query, imageOnly)
    }
}
