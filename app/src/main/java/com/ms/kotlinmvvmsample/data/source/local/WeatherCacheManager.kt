package com.ms.kotlinmvvmsample.data.source.local

import io.reactivex.Single

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 4/16/18
 */
class WeatherCacheManager(private val weatherDao: WeatherDao) : IWeatherCacheManager {

    override fun insertCurrentWeather(localWeather: LocalWeather) {
        weatherDao.deleteWeather()
        weatherDao.insertWeather(localWeather)
    }

    override fun insertForecast(forecasts: List<LocalForecast>) {
        weatherDao.deleteForecast()
        weatherDao.insertForecast(forecasts)
    }

    override fun getCurrentWeatherByCityName(cityName: String): Single<LocalWeather>? {
        return weatherDao.getCurrentWeatherByCityName(cityName)
                .map {
                    it[0]
                }
    }

    override fun getForecast(cityName: String): Single<List<LocalForecast>>? {
        return weatherDao.getForecast(cityName)
    }

    override fun getAll(): Single<List<LocalWeather>>? {
        return weatherDao.getAll()
    }
}