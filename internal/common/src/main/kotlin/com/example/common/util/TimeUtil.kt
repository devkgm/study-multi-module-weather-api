package com.example.common.util

import java.time.LocalTime
import java.time.temporal.ChronoUnit
import java.time.format.DateTimeFormatter

object TimeUtil {
    fun getRoundedTimeToHour(): String {
        val now = LocalTime.now()
        val roundedTime = now.truncatedTo(ChronoUnit.HOURS).withMinute(0)
        val formatter = DateTimeFormatter.ofPattern("HHmm")
        return roundedTime.format(formatter)
    }
}