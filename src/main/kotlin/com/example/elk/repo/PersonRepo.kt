package com.example.elk.repo

import com.example.elk.model.Person
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface PersonRepo : ReactiveCrudRepository<Person, String>
