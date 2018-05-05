package com.ms.kotlinmvvmsample.data.source.local

import com.ms.kotlinmvvmsample.data.source.remote.RemoteWeather
import com.ms.kotlinmvvmsample.data.source.WeatherDataSource
import io.reactivex.Single

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 4/16/18
 */
class WeatherLocalDataSource : WeatherDataSource {
    override fun getCurrentWeatherByCityName(cityName: String): Single<RemoteWeather>? {
        return null
    }
}