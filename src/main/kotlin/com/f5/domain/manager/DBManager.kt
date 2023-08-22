package com.f5.domain.manager

import com.f5.domain.User


interface DBManager {

    fun addUser(user: User): User

    fun getAllUsers(): List<User>

    fun getById(id: Int): User?

    fun delete(id: Int): Boolean
}