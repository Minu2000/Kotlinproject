package com.example.myapp.service

import com.example.myapp.dao.document.TodoList
import com.example.myapp.dao.document.User
import com.example.myapp.dao.repository.TodoListRepository
import com.example.myapp.dao.repository.UserRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TodoListService(@Autowired val todoListRepository: TodoListRepository,
                      @Autowired val userRepository: UserRepository) {

    fun createTodoList(userId: String, accessToken: String,todoList: TodoList): TodoList {
        val user = verifyAccessToken(userId, accessToken)
        val updatedTodoList = todoList.copy(userId = user.userId)
        return todoListRepository.save(todoList)
    }

    private fun verifyAccessToken(userId: String, accessToken: String): User {
        val user = userRepository.findByUserId(userId)
            ?:throw NoSuchElementException("User not found")

        if (!isValidAccessToken(accessToken)) {
            throw IllegalArgumentException("Invalid access token")
        }

        return user
    }

    private fun isValidAccessToken(accessToken: String): Boolean {
        return accessToken =="everything is fine"
    }


    // Add any other methods related to the to-do list service
}
