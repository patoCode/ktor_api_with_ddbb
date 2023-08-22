package com.f5.database

import com.f5.database.entitites.RolTable
import com.f5.domain.Rol
import com.f5.domain.repository.RolesRepository
import org.ktorm.database.asIterable
import org.ktorm.dsl.from
import org.ktorm.dsl.*

class RolesDBRepository : RolesRepository {

    private val _db = DBHelper.database()
    override fun addRol(rol: Rol): Rol {
        _db.insert(RolTable){
            set(it.name, rol.name)
            set(it.code, rol.code)
            set(it.status, rol.status)
        }
        return rol
    }

    override fun getAllRoles(): List<Rol> {
        val dbRol = _db.from(RolTable).select()
        return dbRol.rowSet.asIterable().map{ row ->
            Rol(
                row[RolTable.id] ?: -1,
                "${row[RolTable.name] ?: ""}",
            )
        }
    }

    override fun getById(id: Int): Rol? {
    }

    override fun delete(id: Int): Boolean {
    }

}
