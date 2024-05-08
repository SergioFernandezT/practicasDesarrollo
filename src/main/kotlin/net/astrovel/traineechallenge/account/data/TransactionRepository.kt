package net.astrovel.traineechallenge.account.data

import net.astrovel.traineechallenge.account.domain.Transaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository : JpaRepository<Transaction, Long> {

}