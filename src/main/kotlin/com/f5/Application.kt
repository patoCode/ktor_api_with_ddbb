package com.f5

import com.f5.database.DBHelper.configureDBVariables
import com.f5.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureDBVariables()
    configureSerialization()
    configureRouting()
}

