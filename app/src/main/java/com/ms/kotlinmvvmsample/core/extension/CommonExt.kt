package com.ms.kotlinmvvmsample.core.extension

import java.util.*

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 6/9/18
 */
fun getHourFromMillisecond(milliSeconds: Long): String {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = milliSeconds
    return "${calendar.get(Calendar.HOUR)} ${if (calendar.get(Calendar.AM_PM) == 0) "am" else "pm"}"
}

fun convertKelvinToCelsius(kelvin: Double?): Double {
    kelvin?.apply {
        return kelvin - 273.15
    }

    return 0.0
}