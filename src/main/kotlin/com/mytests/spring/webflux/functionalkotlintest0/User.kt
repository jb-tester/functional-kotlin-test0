package com.mytests.spring.webflux.functionalkotlintest0

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigInteger


@Document
class User(var name: String, var age: Int, var references: List<String>) {
    @Id
    var id: BigInteger? = null

    override fun toString(): String {
        return "User: " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", references=" + references +
                ' '
    }

}
