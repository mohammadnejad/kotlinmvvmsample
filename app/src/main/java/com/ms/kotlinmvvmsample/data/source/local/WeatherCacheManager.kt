package com.ms.kotlinmvvmsample.data.source.local

import com.ms.kotlinmvvmsample.data.source.WeatherDataSource
import com.ms.kotlinmvvmsample.data.source.remote.Forecast
import io.reactivex.Single

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 4/16/18
 */
class WeatherCacheManager(private val weatherDao: WeatherDao) : IWeatherCacheManager {

    override fun insertCurrentWeather(localWeather: LocalWeather) {
        weatherDao.insert(localWeather)
    }

    override fun insertForecast(forecast: LocalForecast) {
    }

    override fun getCurrentWeatherByCityName(cityName: String): Single<LocalWeather>? {
        return weatherDao.getCurrentWeatherByCityName(cityName)
                .map {
                    it[0]
                }
    }

    override fun getForecast(cityName: String): Single<LocalForecast>? {
        return null
    }

    override fun getAll(): Single<List<LocalWeather>>? {
        return weatherDao.getAll()
    }
}