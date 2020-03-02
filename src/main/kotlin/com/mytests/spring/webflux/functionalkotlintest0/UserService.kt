package com.mytests.spring.webflux.functionalkotlintest0

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Service
class UserService {
    @Autowired
    private val repo: UserRepository? = null

    fun findByNames(serverRequest: ServerRequest): Mono<ServerResponse?> {
        return ServerResponse.ok().body(repo!!.findAllByName(serverRequest.pathVariable("personname")), User::class.java)
    }
}
