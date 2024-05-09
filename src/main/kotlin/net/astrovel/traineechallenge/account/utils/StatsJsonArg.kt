package net.astrovel.traineechallenge.account.utils

import com.google.gson.annotations.SerializedName

data class StatsJsonArg (
  @SerializedName("country" ) var country : String? = null,
  @SerializedName("market") var market : List<MarketArg?> =   listOf(MarketArg()),

)