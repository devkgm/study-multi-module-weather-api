package com.example.inquireapplication.weather

import com.example.common.util.DateUtil
import com.example.weatherdomain.Weather
import com.example.weatherdomain.WeatherRepository
import com.example.weatherdomain.WeatherResponse
import org.springframework.stereotype.Service

@Service
class WeatherInquireService(private val weatherRepository: WeatherRepository) {
    fun getTodayWeather(): List<WeatherResponse> {
        val today= DateUtil.getFormattedToday("yyyyMMdd", false)
        try {
            val weatherList = weatherRepository.findByIdFcstDate(today)
            var responseList: ArrayList<WeatherResponse> = ArrayList()
            for (weather in weatherList) {
                responseList.add(WeatherResponse.of(weather))
            }
            return responseList
        } catch (e: Exception) {
            throw Exception("에러")
        }
    }
}