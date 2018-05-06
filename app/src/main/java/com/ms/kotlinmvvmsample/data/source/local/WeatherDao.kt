package com.ms.kotlinmvvmsample.data.source.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

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

    @Query("SELECT * from LocalWeather")
    fun getAll(): List<LocalWeather>
}