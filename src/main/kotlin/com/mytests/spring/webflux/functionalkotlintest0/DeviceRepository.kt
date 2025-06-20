package com.mytests.spring.webflux.functionalkotlintest0

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.math.BigInteger


@Repository
interface DeviceRepository: ReactiveCrudRepository<Device, BigInteger> {
    fun findFirstById(id: Mono<Int?>): Flux<Device>
    fun findFirstByName(name: Mono<String>): Flux<Device>
}
