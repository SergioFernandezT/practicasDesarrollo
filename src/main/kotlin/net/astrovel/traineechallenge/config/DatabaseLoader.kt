package net.astrovel.traineechallenge.config

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.transaction.Transactional
import net.astrovel.traineechallenge.account.core.InterfaceAccountService
import net.astrovel.traineechallenge.account.domain.Account
import net.astrovel.traineechallenge.account.domain.Country
import net.astrovel.traineechallenge.account.domain.Market
import net.astrovel.traineechallenge.account.domain.OperationType
import net.astrovel.traineechallenge.account.domain.Transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class DatabaseLoader(@PersistenceContext private val entityManager: EntityManager) : CommandLineRunner {

    @Autowired
    val accountService: InterfaceAccountService?=null

    @Transactional
    override fun run(vararg args: String) {
        if (isDatabaseEmpty) {
            loadDemoData()
        }
    }

    private val isDatabaseEmpty: Boolean
        get() = (entityManager.createQuery("SELECT COUNT(a) FROM Account a").singleResult as Long) == 0L

    private fun setDemoDataTransactions(): Transaction {

        val rand = Random()
            val amount = rand.nextInt(250000)
            val randomPositiveLong = Math.abs(UUID.randomUUID().getLeastSignificantBits())
            val opTypes = listOf(OperationType.DEPOSITO, OperationType.EXTRACCION)
            val chosenOpType = opTypes[rand.nextInt(opTypes.size)]
            val transaction = Transaction(randomPositiveLong, "Demo Transaction", amount,chosenOpType)
            entityManager.persist(transaction)
        return transaction
    }

    private fun loadDemoData() {
        val marketAR1 =
            Market(IdGenerator.generateId(), "MAE", "Mercado Argentino", Country.ARGENTINA)
        val marketAR2 =
            Market(IdGenerator.generateId(), "ROFEX", "Rosario Futures Exchange", Country.ARGENTINA)
        val marketUY1 =
            Market(IdGenerator.generateId(), "UFEX", "Uruguay Futures Exchange", Country.URUGUAY)

        val markets = listOf(marketAR1, marketAR2, marketUY1)
        markets.forEach { entityManager.persist(it) }

        val rand = Random()
        for (i in 1..50000) {
            val chosenMarket = markets[rand.nextInt(markets.size)]
            var transactionTest = listOf<Transaction>(setDemoDataTransactions(),setDemoDataTransactions(),setDemoDataTransactions())
            val account = Account(Math.abs(UUID.randomUUID().getLeastSignificantBits()), "Demo Account $i", listOf(chosenMarket),transactionTest)
            entityManager.persist(account)
        }
    }
}
