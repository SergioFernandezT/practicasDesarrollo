package net.astrovel.traineechallenge.account.utils

import com.google.gson.annotations.SerializedName

data class StatsJsonUy (
    @SerializedName("country" ) var country : String? = null,
    @SerializedName("market") var market : List<MarketUy?> =   listOf(MarketUy()),

    )