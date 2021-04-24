package com.astrateam.network.imagesnasagov.dao

import com.google.gson.annotations.SerializedName
import java.util.*

data class MediaAssetDataDao(
    var center: String,

    @SerializedName("date_created")
    var dateCreated: Date,

    var keywords: List<String>,

    var title: String,

    var description: String,

    @SerializedName("media_type")
    var mediaType: String,

    @SerializedName("nasa_id")
    var nasaId: String,
)
