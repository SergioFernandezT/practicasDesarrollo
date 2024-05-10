package net.astrovel.traineechallenge.account.core

import net.astrovel.traineechallenge.account.data.TransactionRepository
import net.astrovel.traineechallenge.account.domain.Transaction
import net.astrovel.traineechallenge.account.mapper.toDto
import net.astrovel.traineechallenge.account.mapper.toEntity
import net.astrovel.traineechallenge.account.rest.dto.TransactionDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

import org.springframework.stereotype.Service
import java.util.Optional

@Service
class TransactionService : InterfaceTransactionService {

    @Autowired
    val transactionRepository: TransactionRepository? = null

    override fun all(): Page<TransactionDTO>{
        try {
            return transactionRepository?.findAll(PageRequest.of(0, 10))!!.map{ it.toDto()}
        }catch (e:Exception)
        {
            throw Exception(e.message)
        }
    }

    override fun list(): List<TransactionDTO>{
        try {
            return transactionRepository?.findAll()!!.map{ it.toDto()}
        }catch (e:Exception)
        {
            throw Exception(e.message)
        }
    }

    override fun create(transactionDto: TransactionDTO): Transaction {
        try {
            return transactionRepository?.save(transactionDto.toEntity())!!
        }catch (e:Exception)
        {
            throw Exception(e.message)
        }
    }

    override fun get(idTransactionDto: Long): Transaction? {
        val op: Optional<Transaction>
        try {
            op= transactionRepository!!.findById(idTransactionDto)
        }catch (e:Exception)
        {
            throw Exception(e.message)
        }
        if(!op.isPresent){
            throw Exception("Transaction id $idTransactionDto not found")
        }
        return op.get()
    }

    override fun update(transactionDto: TransactionDTO) : Transaction {
        try {
            return transactionRepository?.save(transactionDto.toEntity())!!
        }catch (e:Exception)
        {
            throw Exception(e.message)
        }
    }
    override fun delete(idTransactionDto: Long) {
        val op: Optional<Transaction>
        try {
            op = transactionRepository!!.findById(idTransactionDto)
        } catch (e: Exception) {
            throw Exception(e.message)
        }
        if (!op.isPresent) {
            throw Exception("Transaction id $idTransactionDto not found")
        } else {
            try {
                transactionRepository!!.deleteById(idTransactionDto)
            } catch (e: Exception) {
                throw Exception(e.message)
            }
        }
    }
}