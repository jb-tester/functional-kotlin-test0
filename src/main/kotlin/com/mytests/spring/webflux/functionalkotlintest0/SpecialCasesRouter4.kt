package com.mytests.spring.webflux.functionalkotlintest0

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

private const val myUrl = "/constRoot"

@Configuration
class SpecialCasesRouter4(val handler: UserService2) {

    // does not work: the '/root1' and '/root2' prefixes are not recognized
    @Bean
    fun routerList() = router {
        listOf("/root1", "/root2").forEach { it.nest { GET("/subroot", handler::simpleHandler) } }
    }


    // doesn't work: the '/varRoot' prefix passed via function is not recognized
    private fun someUrl(): String = "/varRoot"
    @Bean
    fun routerVars(): RouterFunction<ServerResponse> {
        val url = someUrl()
        return router {
            url.nest { GET("/var_subroot", handler::simpleHandler) }
        }
    }

    // endpoint detecting works, but HTTP Request is incorrect: '/const_subroot' suffix is missing
    @Bean
    fun routerConst(): RouterFunction<ServerResponse> {
        val subUrl = "/const_subroot"
        return router {
            myUrl.nest {
                GET(subUrl, handler::simpleHandler) }
        }
    }

}
