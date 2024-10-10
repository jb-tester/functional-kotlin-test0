package com.mytests.spring.webflux.functionalkotlintest0

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.router


@Configuration
open class DeviceRouter3(val handler1: DeviceHandler1 ) {

    

    @Bean
    open fun deviceRouter() = router {
        "/api1".nest {
            (GET("/device/") or GET("/devices/")).invoke(handler1::getAllDevices)
            GET("/device/{id}") { handler1.getDeviceReadings(it) }
        }
        path("/api2").nest {
            (GET("/device/") or GET("/devices/")).invoke(handler1::getAllDevices)
            GET("/device/{id}") { handler1.getDeviceReadings(it) }
        }
        (accept(APPLICATION_JSON) and "/api3").nest {
            (GET("/device/") or GET("/devices/")).invoke(handler1::getAllDevices)
            POST("/device/", handler1::setDeviceReadingApi)
        }
    }
}