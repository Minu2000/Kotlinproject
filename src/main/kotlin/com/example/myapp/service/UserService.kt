package com.example.myapp.service

import com.example.myapp.dao.document.LoginRequest
import com.example.myapp.dao.document.User
import com.example.myapp.dao.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.NoSuchElementException



@Service
class UserService(@Autowired val userRepository: UserRepository) {

    fun createUser(user: User): User {
        return userRepository.save(user)
    }

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun login(loginRequest: LoginRequest): String {
        val user = userRepository.findByEmail(loginRequest.email)
            ?: throw NoSuchElementException("User not found")

        if (user.password != loginRequest.password) {
            throw IllegalArgumentException("Invalid password")
        }

        return generateAccessToken(user)
    }

    private fun generateAccessToken(user: User): String {
        return UUID.randomUUID().toString()
    }
//        val secretKey = "minu_secret_key"
//        val accessTokenExpiration = 86400000

        //val accessToken =
//            Jwts.builder()
//                .setSubject(user.userId)
//                .setIssuedAt(Date())
//                .setExpiration(Date(System.currentTimeMillis() + accessTokenExpiration))
//                .signWith(SignatureAlgorithm.HS256, secretKey)
//                .compact()

}
