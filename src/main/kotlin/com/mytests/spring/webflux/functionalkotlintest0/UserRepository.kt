package com.mytests.spring.webflux.functionalkotlintest0

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.math.BigInteger

/**
 ********************************
 * Created by Irina.Petrovskaya on 3/2/2020.
 * Project: functional-kotlin-test0
 ********************************
 */
interface UserRepository: ReactiveCrudRepository<User, BigInteger> {
    fun findAllByName(name: String):Flux<User>
    fun findAllByAgeGreaterThan(age:Mono<Int>):Flux<User>
    fun findFirstById(id: BigInteger): Mono<User>
}
