package com.ms.kotlinmvvmsample.data.source

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 4/16/18
 */
class WeatherRepository(
        val weatherRemoteDataSource: WeatherDataSource,
        val weatherLocalDataSource: WeatherDataSource
) : WeatherDataSource {

    companion object {
        private var INSTANCE: WeatherRepository? = null

        @JvmStatic
        fun getInstance(weatherRemoteDataSource: WeatherDataSource,
                        weatherLocalDataSource: WeatherDataSource) =
                INSTANCE ?: synchronized(WeatherDataSource::class.java) {
                    INSTANCE ?: WeatherRepository(weatherRemoteDataSource, weatherLocalDataSource)
                            .also { INSTANCE = it }
                }

        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}