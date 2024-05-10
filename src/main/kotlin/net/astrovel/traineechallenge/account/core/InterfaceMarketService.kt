package net.astrovel.traineechallenge.account.core

import net.astrovel.traineechallenge.account.domain.Market
import net.astrovel.traineechallenge.account.rest.dto.MarketDTO
import org.springframework.data.domain.Page

interface InterfaceMarketService {
    fun all(): Page<MarketDTO>
    fun get(idMarketDto:Long): Market?
    fun create(marketDto: MarketDTO): Market
    fun update(marketDto: MarketDTO): Market
    fun delete(idMarketDto:Long)
    fun stats(): List<Int>
}