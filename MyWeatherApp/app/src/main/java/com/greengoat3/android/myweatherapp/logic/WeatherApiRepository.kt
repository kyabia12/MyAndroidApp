package com.greengoat3.android.myweatherapp.logic

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class WeatherApiRepository {
    val moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }


    val apiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(WeatherAPiService::class.java)
    }

    suspend fun getWeatherInfo(lon: Double, lat: Double): OneCallApiResponse? {
        return withContext(Dispatchers.IO) {
            var info: OneCallApiResponse? = null
            val response = apiService.getOneCallData(lon, lat)

            if (response.isSuccessful) {
                info = response.body()
            }
            info
        }
    }
}