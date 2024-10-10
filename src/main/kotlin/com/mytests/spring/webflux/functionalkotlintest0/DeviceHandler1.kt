package com.mytests.spring.webflux.functionalkotlintest0

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono


@Service
class DeviceHandler1 {
    fun getDeviceReadings(request: ServerRequest): Mono<out ServerResponse> {
        return ServerResponse.ok().body("", String::class.java)
    }
    fun getAllDevices(req: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().body("", String::class.java)
    }
    
    fun setDeviceReadingApi(req: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().body("", String::class.java)
    }
}