package com.example.elk.model

import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import java.time.OffsetDateTime

@Document(indexName = "transaction_event")
data class TransactionEvent(
    val id: String,
    val eventType: String,
    @Field(type = FieldType.Date)
    val eventDateTime: OffsetDateTime,
    val transactionId: String,
    @Field(type = FieldType.Date)
    val transactionCreatedDateTime: OffsetDateTime,
    @Field(type = FieldType.Date)
    val transactionUpdatedDateTime: OffsetDateTime,
    val amount: Long,
    val userId: String,
    val card: String,
    val status: String,
    val city: String,
    val merchant: String,
)
