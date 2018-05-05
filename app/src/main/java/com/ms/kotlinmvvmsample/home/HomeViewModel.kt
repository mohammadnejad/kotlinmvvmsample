package com.ms.kotlinmvvmsample.home

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.util.Log
import com.ms.kotlinmvvmsample.data.source.remote.RemoteWeather
import com.ms.kotlinmvvmsample.data.source.WeatherRepository
import com.ms.kotlinmvvmsample.extension.toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 4/21/18
 */
class HomeViewModel(
        private val context: Application,
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
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeBy(
                        onSuccess = {
                            currentWeatherLoadedSuccess(it)
                        },
                        onError = {
                            context.toast(it.message)
                        }
                )
    }

    private fun currentWeatherLoadedSuccess(weather: RemoteWeather?) {
        Log.i(Companion.TAG, "current weather load success" + weather?.toString())
    }

}