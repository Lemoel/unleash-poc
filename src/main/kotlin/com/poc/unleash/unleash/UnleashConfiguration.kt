package com.poc.unleash.unleash

import no.finn.unleash.DefaultUnleash
import no.finn.unleash.Unleash
import no.finn.unleash.util.UnleashConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UnleashConfiguration(
    private val unleashProperties: UnleashProperties
) {

    @Bean
    fun getUnleash(): Unleash =
        UnleashConfig.builder()
            .appName(unleashProperties.appName)
            .instanceId(unleashProperties.instanceId)
            .environment(unleashProperties.environment)
            .unleashAPI(unleashProperties.hostApi)
            .customHttpHeader("Authorization", unleashProperties.token)
            .build().let { DefaultUnleash(it) }
}
