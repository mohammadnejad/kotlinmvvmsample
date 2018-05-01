package com.ms.kotlinmvvmsample.data.source.remote

import com.ms.kotlinmvvmsample.data.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 4/22/18
 */
interface WeatherApi {
    @GET("weather")
    fun getCurrentWeatherByCityName(
            @Query("q") cityName: String,
            @Query("appid") key: String
    ): Single<WeatherResponse>
}