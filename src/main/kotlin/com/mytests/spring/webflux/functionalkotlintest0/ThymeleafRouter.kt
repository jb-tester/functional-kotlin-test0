package com.mytests.spring.webflux.functionalkotlintest0

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import java.net.URI

@Configuration
open class ThymeleafRouter {

    @Bean
    fun test2(): RouterFunction<ServerResponse> {
        return router{
            GET("/test2")
            {
                ServerResponse.ok().render("test2")
            }
        }}
    @Bean
    open fun test1(): RouterFunction<ServerResponse> {
        return router{
            GET("/test1")
            {
                val attr1 = "test1 attribute1"
                val attr2 = "test1 attribute2"
                ServerResponse.ok().render("test1", mapOf("test1_attr1" to attr1, "test1_attr2" to attr2))
            }
    }}

    @Bean
    open fun redirectionRouter(): RouterFunction<ServerResponse> {
        val redirectToTest1 =
                ServerResponse
                        .temporaryRedirect(URI("/test1"))
                        .build()

        return router {
            GET("/redirectMe") {
                redirectToTest1 // also you can create request here
            }
        }
    }
}