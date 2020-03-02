package com.mytests.spring.webflux.functionalkotlintest0

import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.math.BigInteger
import java.net.URI
import java.time.Duration
@Service
class UserService2(val users: UserRepository) {


    fun all(req: ServerRequest): Mono<ServerResponse> {
        return ok().body(this.users.findAll(), User::class.java)
    }

    fun stream(req: ServerRequest): Mono<ServerResponse> {
        val postStream = Flux
                .zip(Flux.interval(Duration.ofSeconds(1)), this.users.findAll())
                .map { it.t2 }
        return ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(
                        postStream,
                        User::class.java
                )
    }



    fun get(req: ServerRequest): Mono<ServerResponse> {
        val id = req.pathVariable("id").toBigInteger()
        return this.users.findFirstById(id)
                .flatMap { post -> ok().body(Mono.just(post), User::class.java) }
                .switchIfEmpty(notFound().build())
    }


}

