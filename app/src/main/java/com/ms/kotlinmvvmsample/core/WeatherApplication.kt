package com.ms.kotlinmvvmsample.core

import android.app.Application
import android.content.Context

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 5/9/18
 */
class WeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        mContext = applicationContext
    }

    companion object {
        var mContext: Context = WeatherApplication.mContext
    }
}