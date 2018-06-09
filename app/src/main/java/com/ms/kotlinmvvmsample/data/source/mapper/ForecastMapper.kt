package com.ms.kotlinmvvmsample.data.source.mapper

import com.ms.kotlinmvvmsample.data.source.local.LocalForecast
import com.ms.kotlinmvvmsample.data.source.remote.RemoteForecast
import java.util.*

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 5/29/18
 */
class ForecastMapper {

    companion object {
        fun transform(remoteForecast: RemoteForecast?): List<LocalForecast>? {
            val localForecasts: MutableList<LocalForecast> = arrayListOf()

            for (forecast in remoteForecast?.forecast!!) {
                val localForecast = LocalForecast(
                        UUID.randomUUID().toString(),
                        forecast.weather?.get(0)?.id!!,
                        forecast.dt,
                        forecast.weather[0].main,
                        forecast.weather[0].description,
                        forecast.weather[0].icon,
                        remoteForecast.city?.name)

                localForecasts.add(localForecast)
            }

            return localForecasts
        }
    }
}