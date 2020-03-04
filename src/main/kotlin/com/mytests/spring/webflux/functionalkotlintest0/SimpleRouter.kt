package com.mytests.spring.webflux.functionalkotlintest0

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse

import org.springframework.web.reactive.function.BodyInserters.fromValue
import org.springframework.web.reactive.function.server.router

/**
 * *******************************
 * Created by Irina.Petrovskaya on 10/31/2019.
 * Project: functional-java-test0
 * *******************************
 */
@Configuration
class SimpleRouter {

    @Bean
    fun simple(): RouterFunction<ServerResponse> {
        return router{
            GET("/test0/functional/simple/{path_var}")
            { req -> ok().body(fromValue("simple" + req.pathVariable("path_var"))) }
        }
    }

}
