package com.ms.kotlinmvvmsample.data.source.local

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 4/16/18
 */

@Entity
data class LocalWeather(
        @PrimaryKey
        val id: Long,

        val coord: Coord?,
        val weather: List<Weather>?,
        val base: String?,
        val main: Main?,
        val visibility: Long,
        val wind: Wind?,
        val cloud: Cloud?,
        val dt: Long,
        val sys: Sys,
        val name: String?,
        val code: Int
)

@Entity
data class Coord(
        val lon: Float,
        val lat: Float
)

@Entity
data class Weather(
        val id: Int,
        val main: String?,
        val description: String?,
        val icon: String?
)

@Entity
data class Main(
        val temp: Float,
        val pressure: Int,
        val humidity: Int,
        val tempMin: Float,
        val tempMax: Float
)

@Entity
data class Wind(
        val speed: Float,
        val deg: Float
)

@Entity
data class Cloud(
        val all: Int
)

@Entity
data class Sys(
        val type: Int,
        val id: Int,
        val message: Float,
        val country: String?,
        val sunrise: Long,
        val sunset: Long
)