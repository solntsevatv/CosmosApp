package com.astrateam.network.apinasagov.dao

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class MarsWeatherDeserializer : JsonDeserializer<MarsWeatherDao> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): MarsWeatherDao {
        val sols: MutableMap<Integer, MarsDayWeatherDao> = mutableMapOf()

        for (entry in json!!.asJsonObject.entrySet()) {
            entry.key.toIntOrNull()?.let {
                val weather = context!!.deserialize<MarsDayWeatherDao>(
                    entry.value, MarsDayWeatherDao::class.java
                )

                sols.put(it as Integer, weather)
            }
        }

        return MarsWeatherDao(sols)
    }
}
