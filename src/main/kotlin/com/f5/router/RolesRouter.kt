package com.f5.router

import com.f5.domain.repository.RolesRepository
import io.ktor.server.routing.*

fun Route.routingRoles(repository: RolesRepository) {
    get{}
    get("{id}"){}
    post{}
    delete("{id}"){}
}