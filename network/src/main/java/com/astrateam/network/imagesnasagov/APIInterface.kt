package com.astrateam.network.imagesnasagov

import com.astrateam.network.imagesnasagov.dao.MediaAssetsListDao
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("/search")
    fun getMediaAssetsList(
        @Query("q") query: String
    ): Call<MediaAssetsListDao>
}
