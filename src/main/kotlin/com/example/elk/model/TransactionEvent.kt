package com.example.elk.model

import com.example.elk.enums.EventType
import com.example.elk.enums.TransactionStatus
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "transaction_event")
data class TransactionEvent(
    val id: String,
    val transactionId: String,
    val eventType: EventType,
    val amount: Long,
    val userId: String,
    val card: String,
    val status: TransactionStatus,
    val city: String,
    val merchant: String,
)
