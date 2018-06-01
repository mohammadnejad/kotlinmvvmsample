package com.ms.kotlinmvvmsample.data.source

import com.ms.kotlinmvvmsample.core.WeatherApplication
import com.ms.kotlinmvvmsample.core.extension.isNetworkAvailable
import com.ms.kotlinmvvmsample.core.extension.toast
import com.ms.kotlinmvvmsample.data.source.local.IWeatherCacheManager
import com.ms.kotlinmvvmsample.data.source.local.LocalForecast
import com.ms.kotlinmvvmsample.data.source.local.LocalWeather
import io.reactivex.Single

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 4/16/18
 */
class WeatherRepository(
        private val weatherRemoteDataSource: WeatherDataSource,
        private val weatherCacheManager: IWeatherCacheManager) : WeatherDataSource {

    override fun getCurrentWeatherByCityName(cityName: String): Single<LocalWeather>? {
        return if (WeatherApplication.mContext.isNetworkAvailable()) {
            WeatherApplication.mContext.toast("online")
            weatherRemoteDataSource.getCurrentWeatherByCityName(cityName)
                    ?.doAfterSuccess {
                        weatherCacheManager.insertCurrentWeather(it)
                    }
        } else {
            WeatherApplication.mContext.toast("offline")
            weatherCacheManager.getCurrentWeatherByCityName(cityName)
        }
    }

    override fun getForecast(cityName: String): Single<LocalForecast>? {
        return if (WeatherApplication.mContext.isNetworkAvailable()) {
            weatherRemoteDataSource.getForecast(cityName)
                    ?.doAfterSuccess {
                        weatherCacheManager.insertForecast(it)
                    }
        } else {
            weatherCacheManager.getForecast(cityName)
        }
    }

    override fun getAll(): Single<List<LocalWeather>>? {
        return null
    }

    companion object {
        private var INSTANCE: WeatherRepository? = null

        @JvmStatic
        fun getInstance(
                weatherRemoteDataSource: WeatherDataSource,
                cacheManager: IWeatherCacheManager) =
                INSTANCE ?: synchronized(WeatherDataSource::class.java) {
                    INSTANCE ?: WeatherRepository(weatherRemoteDataSource, cacheManager)
                            .also { INSTANCE = it }
                }

        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}