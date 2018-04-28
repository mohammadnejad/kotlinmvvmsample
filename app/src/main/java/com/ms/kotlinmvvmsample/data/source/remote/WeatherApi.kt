package com.ms.kotlinmvvmsample.data.source.remote

import com.ms.kotlinmvvmsample.data.Weather
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 4/22/18
 */
interface WeatherApi {
    @GET("forecast?q={city}")
    fun getCurrentWeatherByCityName(@Path("city") cityName: String): Observable<Weather>
}