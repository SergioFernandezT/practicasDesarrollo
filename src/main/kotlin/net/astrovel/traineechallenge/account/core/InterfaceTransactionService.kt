package net.astrovel.traineechallenge.account.core

import net.astrovel.traineechallenge.account.domain.Transaction
import net.astrovel.traineechallenge.account.rest.dto.TransactionDTO
import org.springframework.data.domain.Page

interface InterfaceTransactionService {
    fun all(): Page<TransactionDTO>
    fun get(idTransactionDto:Long): Transaction?
    fun create(accountDto: TransactionDTO): Transaction
    fun update(accountDto: TransactionDTO): Transaction
    fun delete(idTransactionDto:Long)
}