package com.ms.kotlinmvvmsample.data.source

import com.ms.kotlinmvvmsample.data.source.local.LocalWeather
import io.reactivex.Single

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 4/16/18
 */
interface WeatherDataSource {

    fun getCurrentWeatherByCityName(cityName: String): Single<LocalWeather>?

    fun insertCurrentWeather(localWeather: LocalWeather)

    fun getAll(): Single<List<LocalWeather>>?

}