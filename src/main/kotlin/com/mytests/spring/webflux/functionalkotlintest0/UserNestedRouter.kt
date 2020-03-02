package com.mytests.spring.webflux.functionalkotlintest0

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.*
import reactor.core.publisher.Mono

/**
 * *******************************
 * Created by Irina.Petrovskaya on 2/19/2020.
 * Project: functional-java-test0
 * *******************************
 */
@Configuration
class UserNestedRouter {
    @Autowired
    private val repo: UserRepository? = null

    @Bean
    fun nestedRouterFunction(handler: UserService?): RouterFunction<ServerResponse?> {
        return RouterFunctions
                .nest(RequestPredicates.path("/route_nested"),
                        RouterFunctions.route(RequestPredicates.GET("/all"), HandlerFunction { serverRequest: ServerRequest -> getAllUsers(serverRequest) })
                                .andRoute(RequestPredicates.GET("/by_age/{min}"), HandlerFunction { serverRequest: ServerRequest -> getPersonsByAge(serverRequest) })
                                .andRoute(RequestPredicates.GET("/by_name/{personname}"), HandlerFunction
                                {serverRequest: ServerRequest -> handler!!.findByNames(serverRequest) })
                )
    }



    private fun getAllUsers(serverRequest: ServerRequest): Mono<ServerResponse?> {
        return ServerResponse.ok().body(repo!!.findAll(), User::class.java)
    }

    private fun getPersonsByAge(serverRequest: ServerRequest): Mono<ServerResponse?> {
        return ServerResponse.ok().body(repo!!.findAllByAgeGreaterThan(Mono.just(Integer.valueOf(serverRequest.pathVariable(
                "min")))), User::class.java)
    }
}
