package net.astrovel.traineechallenge.service

import net.astrovel.traineechallenge.account.core.InterfaceTransactionService
import net.astrovel.traineechallenge.account.data.TransactionRepository
import net.astrovel.traineechallenge.account.domain.OperationType
import net.astrovel.traineechallenge.account.domain.Transaction
import net.astrovel.traineechallenge.account.mapper.toDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.Random
import java.util.UUID

@SpringBootTest
class TransactionServiceTest {

    @Autowired
    private lateinit var transactionService: InterfaceTransactionService

    @Autowired
    private lateinit var transactionRepository: TransactionRepository

    @BeforeEach
    fun tearDown() {
        transactionRepository.deleteAll()
    }

    @Test
    fun `transaction add 1, get item by ID item test`() {
        val rand = Random()
        val amount = rand.nextInt(250000)
        val randomPositiveLong = Math.abs(UUID.randomUUID().getLeastSignificantBits())
        val opTypes = listOf(OperationType.DEPOSITO, OperationType.EXTRACCION)
        val chosenOpType = opTypes[rand.nextInt(opTypes.size)]
        val transaction1 = Transaction(randomPositiveLong, "Demo Transaction1", amount,chosenOpType)

        transactionService.create(transaction1.toDto())

        val result = transactionService.get(randomPositiveLong)

        assertThat(result).isEqualTo(transaction1)
    }

    @Test
    fun `transaction delete item test`() {
        val rand = Random()
        val amount = rand.nextInt(250000)
        val randomPositiveLong2 = Math.abs(UUID.randomUUID().getLeastSignificantBits())
        val opTypes = listOf(OperationType.DEPOSITO, OperationType.EXTRACCION)
        val chosenOpType = opTypes[rand.nextInt(opTypes.size)]
        val transaction1 = Transaction(randomPositiveLong2, "Demo Transaction1", amount,chosenOpType)

        transactionService.create(transaction1.toDto())
        transactionService.delete(randomPositiveLong2)
        var results = transactionService.list().size

        assertThat(results).isEqualTo(0)
    }
}