package net.astrovel.traineechallenge.account.core

import net.astrovel.traineechallenge.account.data.AccountRepository
import net.astrovel.traineechallenge.account.domain.Account
import net.astrovel.traineechallenge.account.mapper.toDto
import net.astrovel.traineechallenge.account.mapper.toEntity
import net.astrovel.traineechallenge.account.rest.dto.AccountDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

import org.springframework.stereotype.Service
import java.util.Optional

@Service
class AccountService : InterfaceAccountService{

    @Autowired
    val accountRepository: AccountRepository? = null

    override fun all(): Page<AccountDTO>{
        try {
            return accountRepository?.findAll(PageRequest.of(0, 10))!!.map{ it.toDto()}
    }catch (e:Exception)
        {
            throw Exception(e.message)
        }
    }

    override fun create(accountDto: AccountDTO): Account {
    try {
        return accountRepository?.save(accountDto.toEntity())!!
    }catch (e:Exception)
     {
        throw Exception(e.message)
     }
    }

    override fun get(idAccountDto: Long): Account? {
        val op: Optional<Account>
        try {
            op= accountRepository!!.findById(idAccountDto)
        }catch (e:Exception)
        {
            throw Exception(e.message)
        }
        if(!op.isPresent){
            throw Exception("Account id $idAccountDto not found")
        }
        return op.get()
}

    override fun update(accountDto: AccountDTO) : Account {
        try {
            return accountRepository?.save(accountDto.toEntity())!!
        }catch (e:Exception)
        {
            throw Exception(e.message)
        }
    }
    override fun delete(idAccountDto: Long) {
        val op: Optional<Account>
        try {
            op = accountRepository!!.findById(idAccountDto)
        } catch (e: Exception) {
            throw Exception(e.message)
        }
        if (!op.isPresent) {
            throw Exception("Account id $idAccountDto not found")
        } else {
            try {
                accountRepository!!.deleteById(idAccountDto)
            } catch (e: Exception) {
                throw Exception(e.message)
            }
        }
    }
}
