package com.example.myapp.controller
import com.example.myapp.dao.document.LoginRequest
import com.example.myapp.dao.document.TodoList
import com.example.myapp.dao.document.User
import com.example.myapp.service.TodoListService
import com.example.myapp.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(@Autowired val userService: UserService) {

    @PostMapping("/register")
    fun createUser(@RequestBody user: User): User {
        return userService.createUser(user)
    }

    @GetMapping
    fun getAllUsers(): List<User> {
        return userService.getAllUsers()
    }

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): Map<String, String> {
        val accessToken = userService.login(loginRequest)
        return mapOf("accessToken" to accessToken, "message" to "Successfully logged in")
    }


    }
