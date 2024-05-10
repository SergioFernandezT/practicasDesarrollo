package net.astrovel.traineechallenge.account.core

import net.astrovel.traineechallenge.account.domain.Transaction
import net.astrovel.traineechallenge.account.rest.dto.TransactionDTO
import org.springframework.data.domain.Page

interface InterfaceTransactionService {
    fun all(): Page<TransactionDTO>
    fun list(): List<TransactionDTO>
    fun get(idTransactionDto:Long): Transaction?
    fun create(transactionDto: TransactionDTO): Transaction
    fun update(transactionDto: TransactionDTO): Transaction
    fun delete(idTransactionDto:Long)
}