package com.ms.kotlinmvvmsample.data.source

import com.ms.kotlinmvvmsample.core.WeatherApplication
import com.ms.kotlinmvvmsample.core.extension.isNetworkAvailable
import com.ms.kotlinmvvmsample.core.extension.toast
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
        private val weatherLocalDataSource: WeatherDataSource) : WeatherDataSource {

    override fun getAll(): Single<List<LocalWeather>>? {
        return weatherLocalDataSource.getAll()
    }

    override fun insertCurrentWeather(localWeather: LocalWeather) {
        weatherLocalDataSource.insertCurrentWeather(localWeather)
    }

    override fun getCurrentWeatherByCityName(cityName: String): Single<LocalWeather>? {
        return if (WeatherApplication.mContext.isNetworkAvailable()) {
            WeatherApplication.mContext.toast("online")
            weatherRemoteDataSource.getCurrentWeatherByCityName(cityName)
                    ?.doAfterSuccess {
                        insertCurrentWeather(it)
                    }
        } else {
            WeatherApplication.mContext.toast("offline")
            weatherLocalDataSource.getCurrentWeatherByCityName(cityName)
        }
    }

    companion object {
        private var INSTANCE: WeatherRepository? = null

        @JvmStatic
        fun getInstance(
                weatherRemoteDataSource: WeatherDataSource,
                weatherLocalDataSource: WeatherDataSource) =
                INSTANCE ?: synchronized(WeatherDataSource::class.java) {
                    INSTANCE ?: WeatherRepository(weatherRemoteDataSource, weatherLocalDataSource)
                            .also { INSTANCE = it }
                }

        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}