package com.example.myapp.controller

import com.example.myapp.dao.document.TodoList
import com.example.myapp.service.TodoListService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todolists")
class TodoListController(@Autowired val todoListService: TodoListService) {

    @PostMapping("/create")
    fun createTodoList(
        @RequestBody todoList: TodoList
    ): TodoList {
        return todoListService.createTodoList(todoList)
    }
}
