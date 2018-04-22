package com.ms.kotlinmvvmsample.home

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
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

}