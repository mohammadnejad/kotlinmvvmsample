package com.ms.kotlinmvvmsample.data.source.local

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
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
        @ColumnInfo(name = "weatherId")
        val id: Long,

        @PrimaryKey
        val name: String,

        val code: Int,
        val dt: Long,
        val base: String?,
        val visibility: Long,

        @Embedded
        val coord: Coord?,

//        @Embedded
//        val weather: List<Weather>?,

        @Embedded
        val main: Main?,

        @Embedded
        val wind: Wind?,

        @Embedded
        val cloud: Cloud?,

        @Embedded
        val sys: Sys
)

data class Coord(
        val lon: Float,
        val lat: Float
)

data class Weather(
        val id: Int,
        val main: String?,
        val description: String?,
        val icon: String?
)

data class Main(
        val temp: Float,
        val pressure: Int,
        val humidity: Int,
        val tempMin: Float,
        val tempMax: Float
)

data class Wind(
        val speed: Float,
        val deg: Float
)

data class Cloud(
        val all: Int
)

data class Sys(
        val type: Int,
        val id: Int,
        val message: Float,
        val country: String?,
        val sunrise: Long,
        val sunset: Long
)