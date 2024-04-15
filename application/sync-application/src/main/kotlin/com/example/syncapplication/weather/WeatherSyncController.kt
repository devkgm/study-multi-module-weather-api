package com.example.syncapplication.weather

import com.example.weatherdomain.WeatherRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class WeatherSyncController(private val weatherSyncService: WeatherSyncService){
    @PostMapping("/")
    fun syncWeather(): ResponseEntity<Any> {
        try {
            return if (weatherSyncService.syncWeather()){
                ResponseEntity.ok("success")
            } else {
                ResponseEntity.badRequest().build()
            }
        } catch (e: Exception) {
            return ResponseEntity.internalServerError().build()
        }

    }

}