package com.f5.database.entitites

import com.f5.database.common.DBConstants.TABLE_ROL
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object RolTable: Table<Nothing>(TABLE_ROL) {
    val id = int("id").primaryKey()
    val name = varchar("name")
    val code = varchar("code")
    val status = varchar("status")
}