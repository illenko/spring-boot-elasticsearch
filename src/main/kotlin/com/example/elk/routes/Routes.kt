package com.example.elk.routes

import com.example.elk.model.Person
import com.example.elk.repo.PersonRepo
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import org.springframework.web.reactive.function.server.router

@Configuration
class Routes(
    private val personRepo: PersonRepo,
) : WebFluxConfigurer {
    @Bean
    fun personRoutes() =
        router {
            GET("/persons") { ok().body(personRepo.findAll()) }
            GET("/persons/{id}") { ok().body(personRepo.findById(it.pathVariable("id"))) }
            POST("/persons") { ok().body(it.bodyToMono<Person>().flatMap { p -> personRepo.save(p) }) }
        }
}
