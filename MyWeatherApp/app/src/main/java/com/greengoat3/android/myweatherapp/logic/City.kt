package com.greengoat3.android.myweatherapp.logic

import java.util.*

enum class City(val jaCity: String,val lon: Double,val lat: Double) {
    NODATA("--- 都市を選らんでください　---", 0.0, 0.0),
    TOKYO("東京", 1.0, 35.1802),
    NAGOYA("名古屋", 136.9066,35.1802),
    YOKKAICHI("四日市", 136.616,36.6167);

    companion object {
        val VALUE : Array<City> = Arrays.copyOf(values(), values().size)

        fun getCityList(): List<String> {
            val cityList = mutableListOf<String>()

            for (item in VALUE) {
               cityList.add(item.jaCity)
            }

            return cityList
        }

        fun toCity(city: String): City? {
            val cityList = mutableListOf<String>()
            for (item in VALUE) {
                if (city == item.jaCity) {
                    return item
                }
            }
            return null
        }
    }
}