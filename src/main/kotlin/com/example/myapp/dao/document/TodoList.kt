package com.example.myapp.dao.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "todolists")
data class TodoList(
    @Id val id: String = UUID.randomUUID().toString(),
    val title: String,
    val userId: String,
    val items: List<String>,
)
