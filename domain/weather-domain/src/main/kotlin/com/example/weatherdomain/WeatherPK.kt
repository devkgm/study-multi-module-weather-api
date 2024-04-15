package com.example.weatherdomain

import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
data class WeatherPK(
        val fcstDate: String,
        val fcstTime: String,
        val category: String
) : Serializable