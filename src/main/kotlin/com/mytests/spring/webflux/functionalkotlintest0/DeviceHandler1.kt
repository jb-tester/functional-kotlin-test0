package com.mytests.spring.webflux.functionalkotlintest0

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import kotlin.jvm.java


@Service
class DeviceHandler1(private val deviceRepository: DeviceRepository) {
    fun getDeviceReadings(request: ServerRequest): Mono<out ServerResponse> {
        return ServerResponse.ok().body(
            deviceRepository.findFirstByName(Mono.just(
            request.pathVariable(
            "name"))), Device::class.java) }

    fun getAllDevices(req: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().body(deviceRepository.findAll(), Device::class.java)
    }


    fun postDevice(request: ServerRequest): Mono<ServerResponse> {
        val name = request.pathVariable("name")
    return ServerResponse.ok().body(deviceRepository.save(Device(name)), Device::class.java)}
}