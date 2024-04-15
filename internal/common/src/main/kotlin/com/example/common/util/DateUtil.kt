package com.example.common.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object DateUtil {
    fun getFormattedToday(pattern: String,prevDay: Boolean): String {
        val today = LocalDate.now()
        if (prevDay) {
            return today.minusDays(1).format(DateTimeFormatter.ofPattern(pattern))
        } else {
            return today.format(DateTimeFormatter.ofPattern(pattern))
        }
    }
}
