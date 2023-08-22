package com.f5.database

import com.f5.database.common.DBConstants
import io.ktor.server.application.*
import org.ktorm.database.Database

object DBHelper {

    private var dbUrl = ""
    private var dbUser = ""
    private var dbPwd = ""

    fun Application.configureDBVariables(){
        dbUrl = environment.config.propertyOrNull(DBConstants.KEY_DB_URL)?.getString() ?: ""
        dbUser = environment.config.propertyOrNull(DBConstants.KEY_DB_USER)?.getString() ?: ""
        dbPwd = environment.config.propertyOrNull(DBConstants.KEY_DB_PWD)?.getString() ?: ""
    }

    fun database() = Database.connect(
        dbUrl,
        user = dbUser,
        password = dbPwd
    )
}