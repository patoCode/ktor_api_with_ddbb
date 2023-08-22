package com.f5.domain

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int = 0,
    val name: String,
    val lname: String,
    val age: Int
)
