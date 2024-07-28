package com.example.elk.repo

import com.example.elk.model.TransactionEvent
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface TransactionEventRepository : ReactiveCrudRepository<TransactionEvent, String>
