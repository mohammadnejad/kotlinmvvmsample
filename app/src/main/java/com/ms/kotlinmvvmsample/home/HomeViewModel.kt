package com.ms.kotlinmvvmsample.home

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.util.Log
import com.ms.kotlinmvvmsample.data.Weather
import com.ms.kotlinmvvmsample.data.source.WeatherRepository

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 4/21/18
 */
class HomeViewModel(
        context: Application,
        private val weatherRepository: WeatherRepository
) : AndroidViewModel(context) {

    companion object {
        private val TAG = HomeViewModel::class.java.simpleName
    }

    fun start(cityName: String) {
        loadCurrentWeather(cityName)
    }

    fun loadCurrentWeather(cityName: String) {
        weatherRepository.getCurrentWeatherByCityName(cityName)
                ?.subscribe(this::currentWeatherLoadedSuccess)
    }

    private fun currentWeatherLoadedSuccess(weather: Weather) {
        Log.i(Companion.TAG, "current weather load success")
    }

}