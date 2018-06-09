package com.ms.kotlinmvvmsample.data.source.local

import com.ms.kotlinmvvmsample.data.source.IWeatherDataSource

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 6/1/18
 */
interface IWeatherCacheManager : IWeatherDataSource {

    fun insertCurrentWeather(localWeather: LocalWeather)

    fun insertForecast(forecasts: List<LocalForecast>)
}