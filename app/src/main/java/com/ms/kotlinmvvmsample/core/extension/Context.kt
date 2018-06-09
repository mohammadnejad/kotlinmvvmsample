package com.ms.kotlinmvvmsample.core.extension

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

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

fun Context.showNetworkError(throwable: Throwable?) {
    when (throwable) {
        is HttpException -> {
            toast(throwable.response()?.errorBody().toString())
        }
        is SocketTimeoutException -> {
            toast("TimeOutException")
        }
        is IOException -> {
            toast("IOException")
        }
        else -> {
            toast("UnknownException ")
        }
    }
}