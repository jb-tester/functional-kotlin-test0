package com.mytests.spring.webflux.functionalkotlintest0

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigInteger

@Document
class Device(var name: String) {

    @Id var id: BigInteger? = null
    override fun toString(): String {
        return "Device(name='$name', id=$id)"
    }


}