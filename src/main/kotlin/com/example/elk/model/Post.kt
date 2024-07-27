package com.example.elk.model

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "post")
data class Post(
    @Id
    val id: String,
    val title: String,
    val content: String,
    val author: Author,
)
