package com.ms.kotlinmvvmsample.data.source.local

import com.ms.kotlinmvvmsample.data.source.WeatherDataSource
import io.reactivex.Single

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 4/16/18
 */
class WeatherLocalDataSource(private val weatherDao: WeatherDao) : WeatherDataSource {

    override fun insertCurrentWeather(localWeather: LocalWeather) {
        weatherDao.insert(localWeather)
    }

    override fun getCurrentWeatherByCityName(cityName: String): Single<LocalWeather>? {
        return weatherDao.getCurrentWeatherByCityName(cityName)
    }
}