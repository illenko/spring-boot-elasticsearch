package com.example.elk.api.request

import com.example.elk.enums.EventType
import com.example.elk.enums.TransactionStatus

data class TransactionEventRequest(
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
