package com.astrateam.network

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestNetworkHandler {

    @Test
    fun useGetPicture() {
        val response = NetworkHandler.getPicture().execute()
        assert(response.isSuccessful)
    }

    @Test
    fun useGetMarsWeather() {
        val response = NetworkHandler.getMarsWeather().execute()
        assert(response.isSuccessful)
    }

    @Test
    fun useGetMediaAssetsList() {
        val response = NetworkHandler.getMediaAssetsList("moon").execute()
        assert(response.isSuccessful)
    }
}
