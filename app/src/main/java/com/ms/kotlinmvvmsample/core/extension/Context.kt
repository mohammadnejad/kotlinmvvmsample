package com.ms.kotlinmvvmsample.core.extension

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

/**
 * @author majid
 * @version 1.0
 * @date 5/3/18
 */

fun Context.toast(message: String?, duration: Int = Toast.LENGTH_SHORT) =
        Toast.makeText(this, message + "", duration).show()

fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo.isConnected
}