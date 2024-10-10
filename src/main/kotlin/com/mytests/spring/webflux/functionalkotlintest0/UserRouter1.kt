package com.mytests.spring.webflux.functionalkotlintest0

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.*
import reactor.core.publisher.Mono


@Configuration
open class UserRouter1 {
    @Autowired
    private val repo: UserRepository? = null

    @Bean
    open fun nestedRouterFunction(handler: UserService1?): RouterFunction<ServerResponse?> {
        return RouterFunctions
                .nest(RequestPredicates.path("/route_nested"),
                        RouterFunctions.route(RequestPredicates.GET("/all"), HandlerFunction { serverRequest: ServerRequest -> getAllUsers(serverRequest) })
                                .andRoute(RequestPredicates.GET("/by_age/{min}"), HandlerFunction { serverRequest: ServerRequest -> getPersonsByAge(serverRequest) })
                                .andRoute(RequestPredicates.GET("/by_name/{personname}"), HandlerFunction
                                {serverRequest: ServerRequest -> handler!!.findByNames(serverRequest) })
                )
    }



    private fun getAllUsers(serverRequest: ServerRequest): Mono<ServerResponse?> {
        repo!!.findAll().subscribe { println(it) }
        return ServerResponse.ok().body(repo!!.findAll(), User::class.java)
    }

    private fun getPersonsByAge(serverRequest: ServerRequest): Mono<ServerResponse?> {
        return ServerResponse.ok().body(repo!!.findAllByAgeGreaterThan(Mono.just(Integer.valueOf(serverRequest.pathVariable(
                "min")))), User::class.java)
    }
}
