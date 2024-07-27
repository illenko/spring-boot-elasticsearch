package com.example.elk.routes

import com.example.elk.model.Post
import com.example.elk.repo.PostRepo
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import org.springframework.web.reactive.function.server.router

@Configuration
class Routes(
    private val postRepo: PostRepo,
) : WebFluxConfigurer {
    @Bean
    fun postRoutes() =
        router {
            GET("/posts") { ok().body(postRepo.findAll()) }
            GET("/posts/{id}") { ok().body(postRepo.findById(it.pathVariable("id"))) }
            POST("/posts") { ok().body(it.bodyToMono<Post>().flatMap { p -> postRepo.save(p) }) }
        }
}
