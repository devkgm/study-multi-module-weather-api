package com.example.syncapplication

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
//@ComponentScan(basePackages = ["com.example.common"])
@EntityScan(basePackages = ["com.example.weatherdomain"])
@EnableJpaRepositories(basePackages = ["com.example.weatherdomain"])
class SyncApplication

fun main(args: Array<String>) {
    runApplication<SyncApplication>(*args)
}
