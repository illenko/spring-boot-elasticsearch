package com.example.elk.model

import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import java.time.OffsetDateTime

@Document(indexName = "transaction")
data class Transaction(
    val id: String,
    @Field(type = FieldType.Date)
    val createdDateTime: OffsetDateTime,
    @Field(type = FieldType.Date)
    val updatedDateTime: OffsetDateTime,
    val amount: Long,
    val userId: String,
    val card: String,
    val status: String,
    val city: String,
    val merchant: String,
)
