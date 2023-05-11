package com.example.myapp.dao.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document(collection = "users")
data class User(
    @Id val userId: String = UUID.randomUUID().toString(),
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String
)
data class LoginRequest(
    val email: String,
    val password: String
)

