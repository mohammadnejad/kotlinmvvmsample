package com.ms.kotlinmvvmsample.data.source.remote

import com.ms.kotlinmvvmsample.data.base.ApiClient
import com.ms.kotlinmvvmsample.data.source.WeatherDataSource
import com.ms.kotlinmvvmsample.data.source.WeatherMapper
import com.ms.kotlinmvvmsample.data.source.local.LocalWeather
import io.reactivex.Single

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 4/16/18
 */
class WeatherRemoteDataSource : WeatherDataSource {
    private val weatherApi: WeatherApi by lazy {
        ApiClient.getRetrofitInstance().create(WeatherApi::class.java)
    }

    override fun getCurrentWeatherByCityName(cityName: String): Single<LocalWeather>? =
            weatherApi.getCurrentWeatherByCityName(cityName, ApiClient.API_KEY)
                    .map { WeatherMapper.transform(it) }
}