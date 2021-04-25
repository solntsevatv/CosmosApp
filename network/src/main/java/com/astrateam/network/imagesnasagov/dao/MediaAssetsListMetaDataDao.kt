package com.astrateam.network.imagesnasagov.dao

import com.google.gson.annotations.SerializedName

data class MediaAssetsListMetaDataDao(
    @SerializedName("total_hits")
    val totalHits: Int
)
