package com.example.elk.api.request

import java.time.OffsetDateTime

data class TransactionEventRequest(
    val id: String,
    val eventType: String,
    val eventDateTime: OffsetDateTime,
    val transactionId: String,
    val transactionCreatedDateTime: OffsetDateTime,
    val transactionUpdatedDateTime: OffsetDateTime,
    val amount: Long,
    val userId: String,
    val card: String,
    val status: String,
    val city: String,
    val merchant: String,
)
