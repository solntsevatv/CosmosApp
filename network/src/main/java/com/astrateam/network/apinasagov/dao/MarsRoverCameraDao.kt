package com.astrateam.network.apinasagov.dao

import com.google.gson.annotations.SerializedName

data class MarsRoverCameraDao(
    val id: Int,
    val name: String,

    @SerializedName("rover_id")
    val roverId: Int,

    @SerializedName("full_name")
    val fullName: String
)
