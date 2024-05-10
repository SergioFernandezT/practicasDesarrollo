package net.astrovel.traineechallenge.account.domain

import jakarta.persistence.*

    @Entity
    data class Account(
        @Id
        val id: Long = 1L, val description: String = "null",
        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(
            name = "market_account",
            joinColumns = [JoinColumn(name = "account_id")],
            inverseJoinColumns = [JoinColumn(name = "market_id")]
        )
        val markets: List<Market> = emptyList(),
        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "id")
        val transactions: List<Transaction> = emptyList(),
        )