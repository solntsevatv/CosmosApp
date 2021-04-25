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
        val sols: MutableMap<Int, MarsDayWeatherDao> = mutableMapOf()
        for (entry in json!!.asJsonObject["sol_keys"].asJsonArray) {
            entry.asString.toInt().let {
                val weather = context!!.deserialize<MarsDayWeatherDao>(
                    json.asJsonObject[it.toString()],
                    MarsDayWeatherDao::class.java
                )

                sols.put(it, weather)
            }
        }

        return MarsWeatherDao(sols)
    }
}
