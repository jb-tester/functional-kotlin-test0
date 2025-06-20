package com.mytests.spring.webflux.functionalkotlintest0

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router


@Configuration
open class DeviceRouter3(val handler1: DeviceHandler1 ) {

    
    // the prefix "/api2" is used for all routes on HTTP request generating 
    @Bean
    open fun deviceRouter() = router {
        "/api1".nest {
            (GET("/device1/") or GET("/devices1/")).invoke(handler1::getAllDevices)
            GET("/device1/{name}") { handler1.getDeviceReadings(it) }
        }
        path("/api2").nest {
            (GET("/device2/") or GET("/devices2/")).invoke(handler1::getAllDevices)
            GET("/device2/{name}") { handler1.getDeviceReadings(it) }
            POST("/device2/{name}", handler1::postDevice)
        }
        (accept(APPLICATION_JSON) and "/api3").nest {
            (GET("/device3/") or GET("/devices3/")).invoke(handler1::getAllDevices)
            POST("/device3/{name}", handler1::postDevice)
            }
        }
    }
