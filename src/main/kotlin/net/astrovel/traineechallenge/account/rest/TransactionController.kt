package net.astrovel.traineechallenge.account.rest

import net.astrovel.traineechallenge.account.core.InterfaceTransactionService
import net.astrovel.traineechallenge.account.domain.Transaction
import net.astrovel.traineechallenge.account.rest.dto.TransactionDTO
import net.astrovel.traineechallenge.account.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_BASE_TRANSACTIONS)
class TransactionController {

    @Autowired
    val transactionService: InterfaceTransactionService?=null

    @GetMapping("")
    fun all(): ResponseEntity<Page<TransactionDTO>> {
        return try {
            ResponseEntity(transactionService!!.all(), HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/list")
    fun list(): ResponseEntity<List<TransactionDTO>> {
        return try {
            ResponseEntity(transactionService!!.list(), HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PostMapping("")
    fun create(@RequestBody transaction: TransactionDTO): ResponseEntity<Any> {
        return try {
            transactionService!!.create(transaction)
            val responseHeader = HttpHeaders()
            responseHeader.set("location",Constants.URL_BASE_ACCOUNTS + "/" + transaction.id)
            ResponseEntity(responseHeader, HttpStatus.CREATED)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }

    @PutMapping("")
    fun update(@RequestBody transactionDto: TransactionDTO): ResponseEntity<Transaction> {
        return ResponseEntity.ok(transactionService?.update(transactionDto))
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(transactionService!!.get(id), HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(transactionService!!.delete(id), HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}
