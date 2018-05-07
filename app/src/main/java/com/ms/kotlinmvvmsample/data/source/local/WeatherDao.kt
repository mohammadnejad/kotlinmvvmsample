package com.ms.kotlinmvvmsample.data.source.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import io.reactivex.Single

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 5/6/18
 */

@Dao
interface WeatherDao {

    @Insert(onConflict = REPLACE)
    fun insert(weather: LocalWeather)

    @Query("select * from LocalWeather where name = :cityName")
    fun getCurrentWeatherByCityName(cityName: String): Single<LocalWeather>
}