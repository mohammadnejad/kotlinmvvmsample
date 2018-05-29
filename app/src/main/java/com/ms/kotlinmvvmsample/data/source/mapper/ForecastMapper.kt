package com.ms.kotlinmvvmsample.data.source.mapper

import com.ms.kotlinmvvmsample.data.source.local.LocalForecast
import com.ms.kotlinmvvmsample.data.source.remote.RemoteForecast

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 5/29/18
 */
class ForecastMapper {

    companion object {
        fun transform(remoteForecast: RemoteForecast?): LocalForecast? {
            return LocalForecast(remoteForecast?.cnt!!)
        }
    }
}