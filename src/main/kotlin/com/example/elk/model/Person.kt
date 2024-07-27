package com.example.elk.model

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "person")
data class Person(
    @Id
    val id: String,
    val firstName: String,
    val lastName: String,
    val address: Address,
)
