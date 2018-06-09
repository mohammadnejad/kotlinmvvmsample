package com.ms.kotlinmvvmsample.home

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.ms.kotlinmvvmsample.core.extension.showNetworkError
import com.ms.kotlinmvvmsample.data.source.WeatherRepository
import com.ms.kotlinmvvmsample.data.source.local.LocalForecast
import com.ms.kotlinmvvmsample.data.source.local.LocalWeather
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
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

    var mWeather = MutableLiveData<LocalWeather>()
    var mForecast = MutableLiveData<List<LocalForecast>>()
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    companion object {
        private val TAG = HomeViewModel::class.java.simpleName
    }

    fun getCurrentWeather(cityName: String) {
        if (mWeather.value == null) {
            loadCurrentWeather(cityName)
        }
    }

    fun getForecast(cityName: String) {
        if (mForecast.value == null) {
            loadForecast(cityName)
        }
    }

    private fun loadCurrentWeather(cityName: String) {
        weatherRepository.getCurrentWeatherByCityName(cityName)
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeBy(
                        onSuccess = {
                            mWeather.value = it
                        },
                        onError = {
                            context.showNetworkError(it)
                        }
                )?.addTo(compositeDisposable)
    }

    private fun loadForecast(cityName: String) {
        weatherRepository.getForecast(cityName)
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeBy(
                        onSuccess = {
                            mForecast.value = it
                        },
                        onError = {
                            context.showNetworkError(it)
                        }
                )?.addTo(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}