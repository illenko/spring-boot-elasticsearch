package com.example.elk.service

import com.example.elk.api.request.TransactionEventRequest
import com.example.elk.model.Transaction
import com.example.elk.model.TransactionEvent
import com.example.elk.repo.TransactionEventRepository
import com.example.elk.repo.TransactionRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class TransactionEventService(
    private val transactionEventRepository: TransactionEventRepository,
    private val transactionRepository: TransactionRepository,
) {
    fun process(req: TransactionEventRequest) =
        Mono.zip(
            transactionEventRepository.save(req.toTransactionEvent()),
            transactionRepository.save(req.toTransaction()),
        )

    fun TransactionEventRequest.toTransactionEvent() =
        TransactionEvent(
            id = this.id,
            eventDateTime = this.eventDateTime,
            eventType = this.eventType,
            transactionId = this.transactionId,
            transactionCreatedDateTime = this.transactionCreatedDateTime,
            transactionUpdatedDateTime = this.transactionUpdatedDateTime,
            amount = this.amount,
            userId = this.userId,
            card = this.card,
            status = this.status,
            city = this.city,
            merchant = this.merchant,
        )

    fun TransactionEventRequest.toTransaction() =
        Transaction(
            id = this.transactionId,
            createdDateTime = this.transactionCreatedDateTime,
            updatedDateTime = this.transactionUpdatedDateTime,
            amount = this.amount,
            userId = this.userId,
            card = this.card,
            status = this.status,
            city = this.city,
            merchant = this.merchant,
        )
}
