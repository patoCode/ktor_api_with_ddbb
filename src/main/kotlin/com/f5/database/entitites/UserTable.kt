package com.f5.database.entitites

import com.f5.database.common.DBConstants.TABLE_USER
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object UserTable: Table<Nothing>(TABLE_USER) {

    val id = int("id").primaryKey()
    val first_name = varchar("name")
    val last_name = varchar("lname")
    val age = int("age")
}