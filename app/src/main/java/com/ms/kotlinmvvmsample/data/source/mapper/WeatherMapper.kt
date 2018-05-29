package com.ms.kotlinmvvmsample.data.source.mapper

import com.ms.kotlinmvvmsample.data.source.local.*
import com.ms.kotlinmvvmsample.data.source.remote.RemoteWeather
import java.util.*

/**
 * @author majid
 * @version 1.0
 * @date 5/5/18
 */
class WeatherMapper {

    companion object {
        fun transform(remoteWeather: RemoteWeather?): LocalWeather? {

            return LocalWeather(
                    UUID.randomUUID().toString(),
                    remoteWeather?.id!!,
                    remoteWeather.name!!,
                    remoteWeather.code,
                    remoteWeather.dt,
                    remoteWeather.base,
                    remoteWeather.visibility,

                    Coord(
                            remoteWeather.coord?.lon!!,
                            remoteWeather.coord.lat
                    ),
                    Main(
                            remoteWeather.main?.temp!!,
                            remoteWeather.main.pressure,
                            remoteWeather.main.humidity,
                            remoteWeather.main.tempMin,
                            remoteWeather.main.tempMax
                    ),
                    Wind(
                            remoteWeather.wind?.speed!!,
                            remoteWeather.wind.deg
                    ),
                    Cloud(
                            remoteWeather.cloud?.all!!
                    ),
                    Sys(
                            remoteWeather.sys.type,
                            remoteWeather.sys.id,
                            remoteWeather.sys.message,
                            remoteWeather.sys.country,
                            remoteWeather.sys.sunrise,
                            remoteWeather.sys.sunset
                    )

            )

        }
    }
}