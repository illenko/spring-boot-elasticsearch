package com.example.elk.api

import com.example.elk.api.request.TransactionEventRequest
import com.example.elk.service.TransactionEventService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.function.server.bodyToMono
import org.springframework.web.reactive.function.server.router

@Configuration
class Routes(
    private val service: TransactionEventService,
) : WebFluxConfigurer {
    @Bean
    fun postRoutes() =
        router {
            POST("/transaction-events") { req ->
                req.bodyToMono<TransactionEventRequest>().flatMap { service.process(it) }.flatMap { ok().build() }
            }
        }
}
