package com.mytests.spring.webflux.functionalkotlintest0

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router


@Configuration
class GetPostSimpleRouter {
    @Bean
    fun getAndPostTest() = router {
        GET("/testGet") { ServerResponse.ok().bodyValue("testGet") }
        POST("/testPost") { request ->
            request.bodyToMono(String::class.java).flatMap { body ->
                ServerResponse.ok().bodyValue("testPost: received body: $body")
            }
        }
    }
}
