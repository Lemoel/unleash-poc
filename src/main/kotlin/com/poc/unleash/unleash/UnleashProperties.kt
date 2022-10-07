package com.poc.unleash.unleash

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "unleash")
class UnleashProperties(
    val appName: String, val instanceId: String, val environment: String, val hostApi: String, val token: String
)
