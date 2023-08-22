package com.f5.database

import com.f5.domain.User
import com.f5.domain.manager.DBManager
import com.f5.domain.repository.UserRepository

class UserDBRepository : UserRepository {

    private val database: DBManager = DBManagerMSQL()

    override fun addUser(user: User): User {
        database.addUser(user)
        return user
    }

    override fun getAllUsers(): List<User> {
        return database.getAllUsers()
    }

    override fun getById(id: Int): User? {
        return database.getById(id)
    }

    override fun delete(id: Int): Boolean {
        return database.delete(id)
    }
}