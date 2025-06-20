package com.mytests.spring.webflux.functionalkotlintest0

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service


@Service
class DeviceService(private val deviceRepository: DeviceRepository) {
    @PostConstruct
    fun init(){
        println("=============================================")
        println("Devices initialization:")
        println("delete all previously created devices....")
        deviceRepository.deleteAll().block()
        println("create 5 devices....")
        deviceRepository.save(Device("device1")).block()
        deviceRepository.save(Device("device2")).block()
        deviceRepository.save(Device("device3")).block()
        deviceRepository.save(Device("device4")).block()
        deviceRepository.save(Device("device5")).block()
        println("done:")
        deviceRepository.findAll().map { println(it) }.subscribe()
        println("=============================================")
    }
}
