package com.example.elk.repo

import com.example.elk.model.Post
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface PostRepo : ReactiveCrudRepository<Post, String>
