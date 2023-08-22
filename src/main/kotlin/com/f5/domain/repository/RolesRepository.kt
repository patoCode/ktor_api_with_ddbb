package com.f5.domain.repository

import com.f5.domain.Rol

interface RolesRepository {

    fun addRol(rol: Rol): Rol
    fun getAllRoles(): List<Rol>
    fun getById(id: Int) : Rol?
    fun delete(id: Int): Boolean

}