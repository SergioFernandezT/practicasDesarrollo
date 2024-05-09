package net.astrovel.traineechallenge.account.rest

import net.astrovel.traineechallenge.account.core.InterfaceAccountService
import net.astrovel.traineechallenge.account.domain.Account
import net.astrovel.traineechallenge.account.rest.dto.AccountDTO
import net.astrovel.traineechallenge.account.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import net.astrovel.traineechallenge.account.utils.StatsJsonArg
import net.astrovel.traineechallenge.account.utils.MarketArg
import net.astrovel.traineechallenge.account.utils.Percentaje
import net.astrovel.traineechallenge.account.utils.MarketUy
import net.astrovel.traineechallenge.account.utils.StatsJsonUy

@RestController
@RequestMapping(Constants.URL_BASE_ACCOUNTS)
class AccountController {

    @Autowired
    val accountService: InterfaceAccountService?=null

    @GetMapping("")
    fun all(): ResponseEntity<Page<AccountDTO>> {
        return try {
            ResponseEntity(accountService!!.all(), HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PostMapping("")
    fun create(@RequestBody account: AccountDTO): ResponseEntity<Any> {
        return try {
            accountService!!.create(account)
            val responseHeader = HttpHeaders()
            responseHeader.set("location",Constants.URL_BASE_ACCOUNTS + "/" + account.id)
            ResponseEntity(responseHeader, HttpStatus.CREATED)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }

    @PutMapping("")
    fun update(@RequestBody accountDto: AccountDTO): ResponseEntity<Account> {
        return ResponseEntity.ok(accountService?.update(accountDto))
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(accountService!!.get(id), HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(accountService!!.delete(id), HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping("/stats")
    fun stats(): List<Any> {
        var response = listOf(
            StatsJsonArg("Argentina",listOf(MarketArg(Percentaje(80.0), Percentaje(5.3)))),
            StatsJsonUy("Uruguay",listOf(MarketUy(Percentaje(80.0))))
        )
        return response
    }
}
