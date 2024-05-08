package net.astrovel.traineechallenge.account.data

import net.astrovel.traineechallenge.account.domain.Market
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MarketRepository : JpaRepository<Market, Long>