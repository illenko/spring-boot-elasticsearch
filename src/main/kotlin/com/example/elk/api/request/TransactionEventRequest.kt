package com.example.elk.api.request

import com.example.elk.enums.EventType
import com.example.elk.enums.TransactionStatus
import java.time.OffsetDateTime

data class TransactionEventRequest(
    val id: String,
    val eventType: EventType,
    val eventDateTime: OffsetDateTime,
    val transactionId: String,
    val transactionCreatedDateTime: OffsetDateTime,
    val transactionUpdatedDateTime: OffsetDateTime,
    val amount: Long,
    val userId: String,
    val card: String,
    val status: TransactionStatus,
    val city: String,
    val merchant: String,
)
