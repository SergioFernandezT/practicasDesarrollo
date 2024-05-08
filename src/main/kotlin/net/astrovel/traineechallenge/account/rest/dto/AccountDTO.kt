package net.astrovel.traineechallenge.account.rest.dto

import jakarta.transaction.Transaction

data class AccountDTO(
    val id: Long,
    val description: String,
    val markets: List<MarketDTO>,
    val transactions: List<TransactionDTO>
)
