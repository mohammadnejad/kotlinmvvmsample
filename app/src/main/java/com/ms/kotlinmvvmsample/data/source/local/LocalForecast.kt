package com.ms.kotlinmvvmsample.data.source.local

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 5/29/18
 */

@Entity
data class LocalForecast(
        @PrimaryKey
        val primaryId: String,

        val id: Int,
        val dt: Long,
        val main: String?,
        val description: String?,
        val icon: String?,
        val city: String?
)