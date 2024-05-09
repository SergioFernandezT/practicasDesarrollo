package net.astrovel.traineechallenge.account.utils

import com.google.gson.annotations.SerializedName


data class MarketArg (

  @SerializedName("MAE"   ) var MAE: Percentaje = Percentaje(),
  @SerializedName("ROFEX" ) var ROFEX: Percentaje? = Percentaje()

)