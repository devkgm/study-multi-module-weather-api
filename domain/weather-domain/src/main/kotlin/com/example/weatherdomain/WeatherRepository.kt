package com.example.weatherdomain

import org.springframework.data.jpa.repository.JpaRepository


interface WeatherRepository : JpaRepository<Weather, WeatherPK> {
    fun findByIdFcstDate(fcstDate: String): List<Weather>
}