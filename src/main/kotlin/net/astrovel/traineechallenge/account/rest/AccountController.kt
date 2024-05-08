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
    fun stats(): () -> Unit {
//         var market1 = JsonStringEncoder(
//             "country": "Argentina",
//             "market": [{
//             "MAE": {
//             "percentage": "80.75"
//         })
        var response = { }

        return (response)
    }
}
