package com.poc.unleash

import com.poc.unleash.usecase.CanaryUseCase
import no.finn.unleash.Unleash
import no.finn.unleash.UnleashContext
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class UnleashApplicationTests(
	@Autowired private val canaryUseCase: CanaryUseCase,
	@Autowired private val unleash: Unleash,
) {

	@Test
	fun contextLoads() {
		val x = canaryUseCase.toggleCanary("teste")
	}


	@Nested
	inner class TesteUnleash {

		@Test
		fun `percentual`() {

			var mutableMap = mutableMapOf<UUID, Boolean>()

			for (i in 1..50) {
				val uuid = UUID.randomUUID()
				val context = UnleashContext.builder().userId(uuid.toString()).build()
				mutableMap[uuid] = unleash.isEnabled("canary", context)
			}

			val totalTrue = mutableMap.values.count { it }

			val totalFalse = mutableMap.values.count { !it }

			val total = totalTrue + totalFalse

		}

		@Test
		fun `mesmo`() {

			var mutableMap = mutableMapOf<Int, Boolean>()
			val uuid = "663d0128-d2c8-4645-8ecc-c6e986f74497"

			for (i in 1..150) {
				val context = UnleashContext.builder().userId(uuid).build()
				val toggle = unleash.isEnabled("canary", context)
				mutableMap[i] = toggle
			}

			val totalTrue = mutableMap.values.count { it }

			val totalFalse = mutableMap.values.count { !it }

			val total = totalTrue + totalFalse

		}

	}

}
