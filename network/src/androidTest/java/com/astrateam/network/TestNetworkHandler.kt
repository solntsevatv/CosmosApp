package com.astrateam.network

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestNetworkHandler {

    fun getContext(): Context {
        return InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun useGetPicture() = runBlocking {
        val response = NetworkHandler.getPicture()
        assert(!response.url.isNullOrEmpty())
    }

    @Test
    fun useGetMarsWeather() = runBlocking {
        val response = NetworkHandler.getMarsWeather()
        assert(response.sols.isNotEmpty())
    }

    @Test
    fun useGetMediaAssetsList() = runBlocking {
        val response = NetworkHandler.getMediaAssetsList("moon")
        assert(response.items.isNotEmpty())
    }

    @Test
    fun useGetMarsPhotosList() = runBlocking {
        val response = NetworkHandler.getMarsPhotosList("2021-04-24")
        assert(response.photos.size >= 4)
    }
}
