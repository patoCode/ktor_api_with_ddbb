package com.f5.domain.repository

import com.f5.domain.User

interface UserRepository {
    fun addUser(user: User): User
    fun getAllUsers(): List<User>
    fun getById(id: Int): User?
    fun delete(id: Int): Boolean
}