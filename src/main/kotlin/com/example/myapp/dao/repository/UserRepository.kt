package com.example.myapp.dao.repository
import com.example.myapp.dao.document.TodoList
import com.example.myapp.dao.document.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String> {
    fun findByEmail(email: String): User?
    fun findByUserId(userId: String): User?
}

