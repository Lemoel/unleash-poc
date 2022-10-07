package com.poc.unleash

import com.poc.unleash.usecase.CanaryUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1")
class Controller(
    private val canaryUseCase: CanaryUseCase
) {

    @PostMapping("/canary")
    fun startSyncEvent(): ResponseEntity<String> {
        val result = canaryUseCase.toggleCanary()
        return ResponseEntity.status(HttpStatus.CREATED).body(result.toString())
    }

}