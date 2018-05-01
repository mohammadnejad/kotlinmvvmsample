package com.ms.kotlinmvvmsample.data.source.remote

import com.ms.kotlinmvvmsample.data.Weather
import com.ms.kotlinmvvmsample.data.WeatherResponse
import com.ms.kotlinmvvmsample.data.apibase.ApiClient
import com.ms.kotlinmvvmsample.data.source.WeatherDataSource
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

    override fun getCurrentWeatherByCityName(cityName: String): Single<WeatherResponse>? =
            weatherApi.getCurrentWeatherByCityName(cityName, ApiClient.API_KEY)
}