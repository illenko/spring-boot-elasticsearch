package com.example.elk.repo

import com.example.elk.model.Transaction
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface TransactionRepository : ReactiveCrudRepository<Transaction, String>
