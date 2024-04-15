package com.example.weatherdomain

import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "weather")
data class Weather (
        @EmbeddedId
        var id: WeatherPK,
        val baseDate: String,
        val baseTime: String,
        val fcstValue: String,
        val nx: Int,
        val ny: Int
)

