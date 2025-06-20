package com.mytests.spring.webflux.functionalkotlintest0

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

private const val myUrl = "/constRoot"

@Configuration
class UserRouter2(val handler: UserService2) {


    @Bean
    fun routerDsl() = router {
        accept(MediaType.TEXT_HTML).nest {
            GET("/") { ServerResponse.ok().render("home") }
            GET("/hello") { ServerResponse.ok().render("hello") }

        }
        // incorrect HTTP request is generated: '/dsl_route' prefix is missing
        "/dsl_route".nest {
            accept(MediaType.APPLICATION_JSON).nest {
                GET("/users", handler::all)
                GET("/users/{id}", handler::get)
                GET("/users/{age}", handler::getByAge)
            }
            accept(MediaType.TEXT_EVENT_STREAM).nest {
                GET("/users_stream", handler::stream)
            }
        }
    }

    // does not work: the '/root1' and '/root2' prefixes are not recognized
    @Bean
    fun routerList() = router {
        listOf("/root1", "/root2").forEach { it.nest { GET("/subroot", handler::simpleHandler) } }
    }


    // doesn't work: the '/varRoot' prefix is not recognized
    private fun someUrl(): String = "/varRoot"
    @Bean
    fun routerVars(): RouterFunction<ServerResponse> {
        val url = someUrl()
        return router {
            url.nest { GET("/var_subroot", handler::simpleHandler) }
        }
    }

    // endpoint detecting works
    @Bean
    fun routerConst(): RouterFunction<ServerResponse> {
        val subUrl = "/const_subroot"
        return router {
            myUrl.nest {
                GET(subUrl, handler::simpleHandler) }
        }
    }

}
