package com.ms.kotlinmvvmsample.data.apibase

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *
 * @author Majid Mohammadnejad
 * @version 1.0
 * @since 4/22/18
 */
class ApiClient {

    companion object {
        private const val API_BASE_URL = "http://samples.openweathermap.org/data/2.5/"
        const val API_KEY = "8d95c13c65eb2a239ea2dc997ca9d3e0"
        private const val CONNECTION_TIME_OUT = 60L
        private const val READ_TIME_OUT = 60L
        private const val WRITE_TIME_OUT = 60L

        private var mRetrofit: Retrofit? = null

        fun getRetrofitInstance(): Retrofit =
                mRetrofit ?: Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(Gson()))
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                        .client(getOkHttpClient())
                        .build()


        private fun getOkHttpClient(): OkHttpClient =
                OkHttpClient().newBuilder().addInterceptor {
                    val originalRequest: Request = it.request()
//                    val builder = originalRequest.newBuilder().header()
//                    val newRequest = builder.build()
                    it.proceed(originalRequest)
                }.connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
                        .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
                        .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                        .build()
    }
}