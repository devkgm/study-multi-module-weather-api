package com.example.weatherdomain

import jakarta.persistence.Entity

data class WeatherResponse(
    val fcstDate: String,
    val fcstTime: String,
    val category: String,
    val baseDate: String,
    val baseTime: String,
    val fcstValue: String,
    val nx: Int,
    val ny: Int
) {
    companion object{
        fun of(weather: Weather): WeatherResponse{
             return WeatherResponse(
                    weather.id.fcstDate,
                    weather.id.fcstTime,
                    weather.id.category,
                    weather.baseDate,
                    weather.baseTime,
                    weather.fcstValue,
                    weather.nx,
                    weather.ny
            )

        }
    }

    override fun toString(): String {
        return "WeatherResponse(fcstDate='$fcstDate', fcstTime='$fcstTime', category='$category', baseDate='$baseDate', baseTime='$baseTime', fcstValue='$fcstValue', nx=$nx, ny=$ny)"
    }

}