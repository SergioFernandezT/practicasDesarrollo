package net.astrovel.traineechallenge.account.core

import net.astrovel.traineechallenge.account.domain.Account
import net.astrovel.traineechallenge.account.rest.dto.AccountDTO
import org.springframework.data.domain.Page

interface InterfaceAccountService {
    fun all(): Page<AccountDTO>
    fun list(): List<AccountDTO>
    fun get(idAccountDto:Long): Account?
    fun create(accountDto: AccountDTO): Account
    fun update(accountDto: AccountDTO): Account
    fun delete(idAccountDto:Long)
}