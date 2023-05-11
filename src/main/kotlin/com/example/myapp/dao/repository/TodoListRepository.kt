package com.example.myapp.dao.repository

import com.example.myapp.dao.document.TodoList
import org.springframework.data.mongodb.repository.MongoRepository

interface TodoListRepository : MongoRepository<TodoList, String> {

}
