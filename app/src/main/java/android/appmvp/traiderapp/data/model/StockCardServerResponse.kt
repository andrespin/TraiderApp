package android.appmvp.traiderapp.data.model

import com.google.gson.annotations.SerializedName

data class StockCardServerResponse(
    @SerializedName("o")
    val openPriceOfTheDay: Double?,
    @SerializedName("h")
    val highPriceOfTheDay: Double?,
    @SerializedName("l")
    var lowPriceOfTheDay: Double?,
    @SerializedName("c")
    var currentPrice: Double?,
    @SerializedName("pc")
    var previousClosePrice: Double?,
    @SerializedName("logo")
    var logoURL: String?,
    @SerializedName("name")
    var name: String?
)



