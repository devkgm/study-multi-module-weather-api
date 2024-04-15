package com.example.syncapplication.weather

import com.example.common.util.DateUtil
import com.example.common.util.TimeUtil
import com.example.weatherdomain.Weather
import com.example.weatherdomain.WeatherPK
import com.example.weatherdomain.WeatherRepository
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.util.JSONPObject
import com.fasterxml.jackson.module.kotlin.jsonMapper
import org.apache.tomcat.util.json.JSONParser
import org.json.JSONObject
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@Service
class WeatherSyncService(
        private val restTemplate: RestTemplate,
        private val weatherRepository: WeatherRepository,
        @Value("\${api.key.weather}") private val serviceKey: String
) {

    fun syncWeather(): Boolean {
        val today: String
        val time = TimeUtil.getRoundedTimeToHour()
        //05시 발표
        if (time < "0500") today = DateUtil.getFormattedToday("yyyyMMdd", true)
        else today = DateUtil.getFormattedToday("yyyyMMdd", false)

        val uri: URI = UriComponentsBuilder.fromHttpUrl("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst")
                .queryParam("serviceKey", serviceKey)
                .queryParam("pageNo", "1")
                .queryParam("numOfRows", "1000")
                .queryParam("dataType", "JSON")
                .queryParam("base_date", today)
                .queryParam("base_time", "0500")
                //API 제공 X, Y 좌표 경기도 의정부시 문충로74
                .queryParam("nx", "62")
                .queryParam("ny", "130")
                .build(true).toUri()
        try {
            print(uri)
            val response = restTemplate.getForEntity(uri, String::class.java)
            val json = JSONObject(response.body.toString().trimIndent())
            val body = json.getJSONObject("response").getJSONObject("body")
            val items = body.getJSONObject("items").getJSONArray("item")
            val objectMapper = ObjectMapper()

            for (item in items){
                println(item.toString())
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                val weatherPK = objectMapper.readValue(item.toString(), WeatherPK::class.java)
                println("after")

                val weather = objectMapper.readValue(item.toString(), Weather::class.java)

                weather.id = weatherPK
                weatherRepository.save(weather);
            }
            return true
        } catch (ex: Exception) {
            println(ex.message)
            throw Exception("에러")
        }
    }
}