package com.example.inquireapplication.weather

import com.example.common.util.DateUtil
import com.example.common.util.TimeUtil
import com.example.weatherdomain.WeatherRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WeatherInquireController(private val weatherInquireService: WeatherInquireService){
    @GetMapping("/")
    fun getTodayWeather(): ResponseEntity<Any> {
        try {
            val weatherList = weatherInquireService.getTodayWeather()
            return if (weatherList.isEmpty()){
                ResponseEntity.noContent().build()
            } else {
                ResponseEntity.ok(weatherList)
            }
        } catch (e: Exception) {
            return ResponseEntity.internalServerError().build()
        }
    }
}