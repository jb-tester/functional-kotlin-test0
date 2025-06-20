package com.mytests.spring.webflux.functionalkotlintest0

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router


@Configuration
class UserRouter2(val handler: UserService2) {


    @Bean
    fun routerDsl() = router {
        // views are detected, endpoints are detected: ok
        accept(MediaType.TEXT_HTML).nest {
            GET("/") { ServerResponse.ok().render("home") }
            GET("/hello") { ServerResponse.ok().render("hello") }

        }
        //  '/dsl_route' prefix is not recognized; if you comment-out the above part, then this will work.
        "/dsl_route".nest {
            accept(MediaType.APPLICATION_JSON).nest {
                GET("/users", handler::all)
                GET("/users/{id}", handler::get)
                GET("/usersByAge/{age}", handler::getByAge)
            }
            accept(MediaType.TEXT_EVENT_STREAM).nest {
                GET("/users_stream", handler::stream)
            }
        }
    }


}
