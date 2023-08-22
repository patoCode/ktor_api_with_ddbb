package com.f5.router

import com.f5.domain.User
import com.f5.domain.repository.UserRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.routingUsers(repository: UserRepository) {
    post {
        val request = call.receive<User>()
        val addedUser = repository.addUser(request)
        call.respond(
            HttpStatusCode.Created,
            addedUser
        )
    }
    get("{id}") {
        val id = call.parameters["id"]?.toInt() ?: 0
        val user = repository.getById(id)
        user?.let {
            call.respond(HttpStatusCode.Found, it)
        }?: call.respond(HttpStatusCode.NotFound,"user not found with id $id")
    }
    get {
        val users = repository.getAllUsers()
        // call.application.environment.log.info(users.toString())
        if(users.isEmpty()) call.respondText("No existen usuarios registrados en la BD", status = HttpStatusCode.NoContent)
        else call.respond(HttpStatusCode.OK, users)
    }
    delete("{id}") {
        val id = call.parameters["id"]?.toInt() ?: 0
        val result = repository.delete(id)
        call.respond(
            if (result) HttpStatusCode.OK else HttpStatusCode.NotFound,
            if (result) "User with id $id deleted" else "User with id $id not found"
        )
    }
}