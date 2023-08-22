package com.f5.plugins

import com.f5.database.RolesDBRepository
import com.f5.database.UserDBRepository
import com.f5.domain.repository.*
import com.f5.router.*
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    val repository: UserRepository = UserDBRepository()
    val rolsRepository: RolesRepository = RolesDBRepository()

    routing {
        route("/users"){
            routingUsers(repository)
        }
        route("/roles"){
            routingRoles(rolsRepository)
        }
    }
}


