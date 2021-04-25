package com.astrateam.network.apinasagov.dao

import com.google.gson.annotations.SerializedName

data class MarsPhotoDao(
    val id: Int,
    val sol: Int,

    val camera: MarsRoverCameraDao,

    @SerializedName("img_src")
    val imageSrc: String,

    @SerializedName("earth_date")
    val earthDate: String
)
