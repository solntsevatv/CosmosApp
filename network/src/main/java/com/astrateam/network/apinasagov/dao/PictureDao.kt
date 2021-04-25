package com.astrateam.network.apinasagov.dao

import com.google.gson.annotations.SerializedName

data class PictureDao(
    var url: String?,

    @SerializedName("media_type")
    var mediaType: String?,

    var explanation: String?,

    var concepts: Any?,

    var title: String?,

    val additionalProperties: MutableMap<String, Any>
)
