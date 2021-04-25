package com.astrateam.database

import android.content.Context
import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import java.text.SimpleDateFormat
import java.util.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NetworkRepositoryTest {
    private val DEBUG_TAG = "com.astrateam.database.NetworkRepositoryTest"

    fun getContext(): Context {
        return InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun useGetPicture() = runBlocking {
        val picture = NetworkRepository.getPicture(Date())
        assert(!picture.uri.path.isNullOrEmpty())
    }

    @Test
    fun useGetMarsWeather() = runBlocking {
        val date = Date()
        val marsWeather = NetworkRepository.getMarsWeather(date)
        Log.d(DEBUG_TAG, marsWeather.date.toString())
        Log.d(DEBUG_TAG, marsWeather.temperature.toString())
        Log.d(DEBUG_TAG, marsWeather.pressure.toString())
        assert(marsWeather.date == date)
    }

    @Test
    fun useGetMediaAssets() = runBlocking {
        val assets = NetworkRepository.getMediaAssets(Date(), 4, "Mars", false)
        Log.d(DEBUG_TAG, assets.size.toString())
        Log.d(DEBUG_TAG, assets[0].title)
        Log.d(DEBUG_TAG, assets[0].body)
        assert(assets.size == 4)
    }

    @Test
    fun useGetMarsPhotos() = runBlocking {
        val date = SimpleDateFormat("yyyy-MM-dd").parse("2021-04-24")!!
        val photos = NetworkRepository.getMarsPhotos(date)
        photos.forEach { Log.d(DEBUG_TAG, "Mars photo url: " + it.url) }
        assert(photos.isNotEmpty())
    }
}
