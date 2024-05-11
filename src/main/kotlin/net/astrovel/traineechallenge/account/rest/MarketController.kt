package net.astrovel.traineechallenge.account.rest

import net.astrovel.traineechallenge.account.core.InterfaceAccountService
import net.astrovel.traineechallenge.account.core.InterfaceMarketService
import net.astrovel.traineechallenge.account.domain.Market
import net.astrovel.traineechallenge.account.rest.dto.MarketDTO
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
import java.util.Optional


@RestController
@RequestMapping(Constants.URL_BASE_MARKETS)
class MarketController {

    @Autowired
    val marketService: InterfaceMarketService?=null

    @Autowired
    val accountService: InterfaceAccountService?=null

    @GetMapping("")
    fun all(): ResponseEntity<Page<MarketDTO>> {
        return try {
            ResponseEntity(marketService!!.all(), HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PostMapping("")
    fun create(@RequestBody market: MarketDTO): ResponseEntity<Any> {
        return try {
            marketService!!.create(market)
            val responseHeader = HttpHeaders()
            responseHeader.set("location",Constants.URL_BASE_ACCOUNTS + "/" + market.id)
            ResponseEntity(responseHeader, HttpStatus.CREATED)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }

    @PutMapping("")
    fun update(@RequestBody marketDto: MarketDTO): ResponseEntity<Market> {
        return ResponseEntity.ok(marketService?.update(marketDto))
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(marketService!!.get(id), HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(marketService!!.delete(id), HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping("/stats")
    fun stats(): Any? {
        var salida: List<Long>? = emptyList<Long>()
        try {
            salida = marketService?.stats()
        }
        catch (e:Exception)
        {
            throw Exception(e.message)
        }
        var totalAccounts = accountService?.list()?.size!!.toDouble()
        var mae = salida?.get(0)?.div(totalAccounts)
        var rofex = salida?.get(1)?.div(totalAccounts)
        var ufex = salida?.get(2)?.div(totalAccounts)
        var response = listOf(
            StatsJsonArg("Argentina",
                listOf(MarketArg(Percentaje(rofex), Percentaje(mae)))),
            StatsJsonUy("Uruguay",listOf(MarketUy(Percentaje(ufex))))
        )
        return response
    }
}