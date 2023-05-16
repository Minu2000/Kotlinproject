package com.example.myapp.service

import com.example.myapp.dao.document.TodoList
//import com.example.myapp.dao.document.User
import com.example.myapp.dao.repository.TodoListRepository
import com.example.myapp.dao.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

//@Service
//class TodoListService(
//    @Autowired val todoListRepository: TodoListRepository,
//    @Autowired val userRepository: UserRepository
//) {
//
//    fun createTodoList(todoList: TodoList): TodoList {
//        val user = verifyUserExists(todoList.userId)
//        val updatedTodoList = todoList.copy(userId = user.userId)
//        return todoListRepository.save(updatedTodoList)
//    }
//
//    private fun verifyUserExists(userId: String): User {
//        val user = userRepository.findByUserId(userId)
//        if (user == null) {
//            println("User not found in the database for userId: $userId")
//            throw NoSuchElementException("Minu not found")
//        }
//        println("User found in the database. Retrieved userId: ${user.userId}")
//        return user
//    }
@Service
class TodoListService(
    @Autowired val todoListRepository: TodoListRepository,
   //@Autowired val userRepository: UserRepository
) {

    fun createTodoList(todoList: TodoList): TodoList {
        return todoListRepository.save(todoList)
    }
    fun updateTodoList(id: String, updatedTodoList: TodoList): TodoList {
        val existingTodoList = todoListRepository.findById(id)
            .orElseThrow { NoSuchElementException("Todo List not found with id: $id") }

        val modifiedTodoList = existingTodoList.copy(
            title = updatedTodoList.title,
            items = updatedTodoList.items
        )

        return todoListRepository.save(modifiedTodoList)
    }

    fun deleteTodoList(id: String) {
        val existingTodoList = todoListRepository.findById(id)
            .orElseThrow { NoSuchElementException("Todo List not found with id: $id") }

        todoListRepository.delete(existingTodoList)
    }

}






