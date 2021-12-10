package com.greengoat3.android.myweatherapp.logic

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPiService {
    @GET("/data/2.5/onecall?exclude=current,minutely,daily&appid=9c61be82b1cc71e228fa5e4639f5c7df&units=metric&lang=ja")
    suspend fun getOneCallData(
        @Query("lon") lon: Double,
        @Query("lat") lat: Double
    ): Response<OneCallApiResponse>
}

data class OneCallApiResponse(
    // 変数名とJSONのキー名を一致させている
    val lat: Double, // 緯度
    val lon: Double, // 経度
    val hourly: List<HourlyResponse>? // 時間ごとの天気予報データAPI応答
    )

data class HourlyResponse(
    // 変数名とJSONのキー名を一致させている
    val dt: Int, // 予測データの時刻
    val temp: Double,
    val feels_like: Double,
    val pressure: Double,
    val humidity: Int,
    val dew_point: Double,
    val uvi: Double,
    val clouds: Int,
    val visibility: Int,
    val wind_speed: Double,
    val wind_gust: Double?,
    val wind_deg: Int,
    val pop: Double,
    val weather: List<WeatherResponse>
    )

data class WeatherResponse(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
    )
