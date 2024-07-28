package com.example.elk.model

import com.example.elk.enums.TransactionStatus
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "transaction")
data class Transaction(
    val id: String,
    val amount: Long,
    val userId: String,
    val card: String,
    val status: TransactionStatus,
    val city: String,
    val merchant: String,
)
