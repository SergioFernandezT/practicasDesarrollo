package net.astrovel.traineechallenge.account.domain
import jakarta.persistence.*

@Entity
data class Transaction(
    @Id
    val id: Long = 1L,
    val description: String = "null",
    val amount: Int = 0,
    val operationType: OperationType? = OperationType.DEPOSITO,
)