package com.astrateam.network.imagesnasagov.dao

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class MediaAssetsListDeserializer : JsonDeserializer<MediaAssetsListDao> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): MediaAssetsListDao {
        return Gson().fromJson(json!!.asJsonObject["collection"], MediaAssetsListDao::class.java)
    }
}
