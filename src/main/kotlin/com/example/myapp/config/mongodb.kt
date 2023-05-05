package com.example.myapp.config
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDatabaseFactory
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory

@Configuration
class MongodbConfiguration(
    @Value("\${mongodb_uri}") private val mongoUri: String
) {

    fun mongoTemplate(): MongoTemplate {
        val factory: MongoDatabaseFactory = SimpleMongoClientDatabaseFactory(mongoUri)
        return MongoTemplate(factory)
    }
}
