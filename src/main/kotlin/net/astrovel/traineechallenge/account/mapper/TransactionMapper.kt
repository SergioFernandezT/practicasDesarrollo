package net.astrovel.traineechallenge.account.mapper

import net.astrovel.traineechallenge.account.domain.OperationType
import net.astrovel.traineechallenge.account.domain.Transaction
import net.astrovel.traineechallenge.account.rest.dto.TransactionDTO

fun Transaction.toDto() = TransactionDTO(
    id, description, amount, operationType?.name ?: "Unknown"
)

fun TransactionDTO.toEntity(): Transaction {
    return Transaction(
        id, description, amount, OperationType.valueOf(operationType)
    )
}