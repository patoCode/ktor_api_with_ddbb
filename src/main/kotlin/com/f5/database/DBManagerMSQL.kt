package com.f5.database

import com.f5.database.entitites.UserTable
import com.f5.domain.manager.DBManager
import com.f5.domain.User
import org.ktorm.database.asIterable
import org.ktorm.dsl.*

class DBManagerMSQL: DBManager {
    private val database = DBHelper.database()

    override fun addUser(user: User): User {
        database.insert(UserTable) {
            set(it.first_name, user.name)
            set(it.last_name, user.lname)
            set(it.age, user.age)
        }
        return user
    }


    override fun getAllUsers(): List<User> {
        val dbUser = database.from(UserTable).select()
        return dbUser.rowSet.asIterable().map { row ->
            User(
                row[UserTable.id] ?: -1,
                "${row[UserTable.first_name] ?: ""}",
                "${row[UserTable.last_name] ?: ""}",
                row[UserTable.age] ?: -1
            )
        }
    }

    override fun getById(id: Int): User? {
        val dbUser = database.from(UserTable).select().where { UserTable.id eq id }
        val row = dbUser.rowSet.asIterable().firstOrNull()
        return row?.let {
            User(
                it[UserTable.id] ?: -1,
                "${it[UserTable.first_name] ?: ""}",
                "${it[UserTable.last_name] ?: ""}",
                it[UserTable.age] ?: -1
            )
        }?: null
    }

    override fun delete(id: Int): Boolean {
        val affectedRow = database.delete(UserTable) { it.id eq id }
        return affectedRow == 1
    }
}