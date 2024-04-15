package com.example.inquireapplication

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScans
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
//@ComponentScan(basePackages = ["com.example.weatherdomain"])
@EntityScan(basePackages = ["com.example.weatherdomain"])
@EnableJpaRepositories(basePackages = ["com.example.weatherdomain"])
class InquireApplication

fun main(args: Array<String>) {
    runApplication<InquireApplication>(*args)
}
