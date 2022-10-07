package com.poc.unleash

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication


@SpringBootApplication
@ConfigurationPropertiesScan
class UnleashApplication

fun main(args: Array<String>) {
	runApplication<UnleashApplication>(*args)
}
