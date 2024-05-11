package net.astrovel.traineechallenge.account.domain

import jakarta.persistence.*

    @Entity
    @Table(name = "accounts")
    class Account(
        @Id
        val id: Long = 1L, val description: String = "null",
        @JoinTable(
            name = "market_account",
            joinColumns = [JoinColumn(name = "account_id")],
            inverseJoinColumns = [JoinColumn(name = "market_id")]
        )
        @ManyToMany(fetch = FetchType.LAZY)
        val markets: List<Market> = emptyList(),
        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "id")
        val transactions: List<Transaction> = emptyList(),
        )