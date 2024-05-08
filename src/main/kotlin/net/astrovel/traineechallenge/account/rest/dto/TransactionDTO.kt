package net.astrovel.traineechallenge.account.rest.dto

data class TransactionDTO(
    val id: Long,
    val description: String,
    val amount: Int,
    val operationType: String
)