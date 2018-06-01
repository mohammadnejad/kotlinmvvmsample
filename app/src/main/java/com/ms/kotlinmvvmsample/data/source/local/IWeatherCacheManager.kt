package com.ms.kotlinmvvmsample.data.source.local

import com.ms.kotlinmvvmsample.data.source.WeatherDataSource

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 6/1/18
 */
interface IWeatherCacheManager : WeatherDataSource {

    fun insertCurrentWeather(localWeather: LocalWeather)

    fun insertForecast(forecast: LocalForecast)
}