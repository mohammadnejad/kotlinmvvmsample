package com.ms.kotlinmvvmsample.data.source.remote

import com.google.gson.annotations.SerializedName

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 4/16/18
 */
data class RemoteWeather(
        @SerializedName("coord") val coord: Coord?,
        @SerializedName("weather") val weather: List<Weather>?,
        @SerializedName("base") val base: String?,
        @SerializedName("main") val main: Main?,
        @SerializedName("visibility") val visibility: Long,
        @SerializedName("wind") val wind: Wind?,
        @SerializedName("clouds") val cloud: Cloud?,
        @SerializedName("dt") val dt: Long,
        @SerializedName("sys") val sys: Sys,
        @SerializedName("id") val id: Long,
        @SerializedName("name") val name: String?,
        @SerializedName("cod") val code: Int
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
        @SerializedName("temp_min") val tempMin: Float,
        @SerializedName("temp_max") val tempMax: Float
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