package com.f5.domain

import com.f5.domain.common.StatusValue

data class Rol(
    val id: Int = 0,
    val name: String,
    val code: String,
    val status: StatusValue = StatusValue.active
){
    override fun toString(): String = "Rol( $name $code, ${status.toString()})"
}
