package com.ms.kotlinmvvmsample

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ms.kotlinmvvmsample.data.source.WeatherRepository
import com.ms.kotlinmvvmsample.data.source.local.WeatherLocalDataSource
import com.ms.kotlinmvvmsample.data.source.remote.WeatherRemoteDataSource

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 4/16/18
 */
class ViewModelFactory private constructor(
        private val application: Application,
        private val weatherRepository: WeatherRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
            with(modelClass) {
                when {
                }
            } as T

    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application) =
                INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                    INSTANCE ?: ViewModelFactory(application,
                            WeatherRepository.getInstance(WeatherLocalDataSource(), WeatherRemoteDataSource()))
                            .also { INSTANCE = it }
                }
    }
}