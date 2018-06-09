package com.ms.kotlinmvvmsample.data.source.remote

import com.ms.kotlinmvvmsample.data.base.ApiClient
import com.ms.kotlinmvvmsample.data.source.IWeatherDataSource
import com.ms.kotlinmvvmsample.data.source.local.LocalForecast
import com.ms.kotlinmvvmsample.data.source.local.LocalWeather
import com.ms.kotlinmvvmsample.data.source.mapper.ForecastMapper
import com.ms.kotlinmvvmsample.data.source.mapper.WeatherMapper
import io.reactivex.Single

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 4/16/18
 */
class WeatherRemoteDataSource : IWeatherDataSource {

    private val weatherApi: WeatherApi by lazy {
        ApiClient.getRetrofitInstance().create(WeatherApi::class.java)
    }

    override fun getCurrentWeatherByCityName(cityName: String): Single<LocalWeather>? =
            weatherApi.getCurrentWeatherByCityName(cityName, ApiClient.API_KEY)
                    .map { WeatherMapper.transform(it) }

    override fun getForecast(cityName: String): Single<List<LocalForecast>>? =
            weatherApi.getForecast(cityName, ApiClient.API_KEY)
                    .map { ForecastMapper.transform(it) }

    override fun getAll(): Single<List<LocalWeather>>? {
        return null
    }
}