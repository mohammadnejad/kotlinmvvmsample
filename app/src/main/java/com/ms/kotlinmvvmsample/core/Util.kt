package com.ms.kotlinmvvmsample.core

import android.content.Context
import android.net.ConnectivityManager


/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 5/9/18
 */
class Util {

    companion object {
        fun isNetworkAvailable(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo.isConnected
        }
    }
}