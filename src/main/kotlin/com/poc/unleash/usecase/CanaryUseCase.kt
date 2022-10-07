package com.poc.unleash.usecase

import no.finn.unleash.Unleash
import no.finn.unleash.UnleashContext
import org.springframework.stereotype.Service
import java.util.*

@Service
class CanaryUseCase(
    private val unleash: Unleash,
) {

    fun toggleCanary(): Boolean {
        val context = UnleashContext.builder().userId(UUID.randomUUID().toString()).build()
        return unleash.isEnabled("canary", context)
    }

}
