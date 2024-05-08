package net.astrovel.traineechallenge.account.data

import net.astrovel.traineechallenge.account.domain.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : JpaRepository<Account, Long>
