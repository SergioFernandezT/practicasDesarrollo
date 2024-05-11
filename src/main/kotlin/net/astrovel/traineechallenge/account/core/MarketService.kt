package net.astrovel.traineechallenge.account.core

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
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
class MarketService(@PersistenceContext private val entityManager: EntityManager) : InterfaceMarketService{
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

    override fun list(): List<MarketDTO> {
        try {
            return marketRepository?.findAll()!!.map{ it.toDto()}
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

    override fun stats(): List<Long>? {
        try {
            val results = entityManager.createNativeQuery(
            "SELECT COUNT(a.id) FROM accounts a INNER JOIN market_account ma " +
                    "ON a.id = ma.account_id INNER JOIN markets m ON m.id = ma.market_id " +
                    " GROUP BY m.code ORDER BY m.code").resultList
            return results as List<Long>?
        }catch (e:Exception)
        {
            throw Exception(e.message)
        }
    }
}