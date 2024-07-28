package com.example.elk.service

import com.example.elk.api.request.TransactionEventRequest
import com.example.elk.model.Transaction
import com.example.elk.model.TransactionEvent
import com.example.elk.repo.TransactionEventRepository
import com.example.elk.repo.TransactionRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.util.function.Tuple2

@Service
class TransactionEventService(
    private val transactionEventRepository: TransactionEventRepository,
    private val transactionRepository: TransactionRepository,
) {
    fun process(req: TransactionEventRequest): Mono<Tuple2<TransactionEvent, Transaction>> =
        Mono.zip(
            transactionEventRepository.save(
                TransactionEvent(
                    id = req.id,
                    eventDateTime = req.eventDateTime,
                    eventType = req.eventType,
                    transactionId = req.transactionId,
                    transactionCreatedDateTime = req.transactionCreatedDateTime,
                    transactionUpdatedDateTime = req.transactionUpdatedDateTime,
                    amount = req.amount,
                    userId = req.userId,
                    card = req.card,
                    status = req.status,
                    city = req.city,
                    merchant = req.merchant,
                ),
            ),
            transactionRepository.save(
                Transaction(
                    id = req.transactionId,
                    createdDateTime = req.transactionCreatedDateTime,
                    updatedDateTime = req.transactionUpdatedDateTime,
                    amount = req.amount,
                    userId = req.userId,
                    card = req.card,
                    status = req.status,
                    city = req.city,
                    merchant = req.merchant,
                ),
            ),
        )
}
