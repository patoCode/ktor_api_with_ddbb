package com.f5.plugins

import com.f5.database.UserDBRepository
import com.f5.domain.repository.UserRepository
import com.f5.router.*
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    val repository: UserRepository = UserDBRepository()

    routing {
        route("/users"){
            routingUsers(repository)
        }
    }
}


