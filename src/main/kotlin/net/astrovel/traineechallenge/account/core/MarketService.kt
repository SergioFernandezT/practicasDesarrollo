package net.astrovel.traineechallenge.account.core

import net.astrovel.traineechallenge.account.data.MarketRepository
import net.astrovel.traineechallenge.account.domain.Market
import net.astrovel.traineechallenge.account.mapper.toDto
import net.astrovel.traineechallenge.account.mapper.toEntity
import net.astrovel.traineechallenge.account.rest.dto.MarketDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

import org.springframework.stereotype.Service
import java.util.Optional

@Service
class MarketService : InterfaceMarketService{
    @Autowired
    val marketRepository: MarketRepository? = null

    override fun all(): Page<MarketDTO> {
        try {
            return marketRepository?.findAll(PageRequest.of(0, 10))!!.map{ it.toDto()}
        }catch (e:Exception)
        {
            throw Exception(e.message)
        }
    }

    override fun create(marketDto: MarketDTO): Market {
        try {
            return marketRepository?.save(marketDto.toEntity())!!
        }catch (e:Exception)
        {
            throw Exception(e.message)
        }
    }

    override fun get(idMarketDto: Long): Market? {
        val op: Optional<Market>
        try {
            op= marketRepository!!.findById(idMarketDto)
        }catch (e:Exception)
        {
            throw Exception(e.message)
        }
        if(!op.isPresent){
            throw Exception("Market id $idMarketDto not found")
        }
        return op.get()
    }

    override fun update(marketDto: MarketDTO) : Market {
        try {
            return marketRepository?.save(marketDto.toEntity())!!
        }catch (e:Exception)
        {
            throw Exception(e.message)
        }
    }
    override fun delete(idMarketDto: Long) {
        val op: Optional<Market>
        try {
            op = marketRepository!!.findById(idMarketDto)
        } catch (e: Exception) {
            throw Exception(e.message)
        }
        if (!op.isPresent) {
            throw Exception("Market id $idMarketDto not found")
        } else {
            try {
                marketRepository!!.deleteById(idMarketDto)
            } catch (e: Exception) {
                throw Exception(e.message)
            }
        }
    }

    override fun stats(): List<Int>{
        try {
            val allMarkets = all().groupBy { it.code }.count()
            val results = allMarkets

            return results as List<Int>
        }catch (e:Exception)
        {
            throw Exception(e.message)
        }
    }
}