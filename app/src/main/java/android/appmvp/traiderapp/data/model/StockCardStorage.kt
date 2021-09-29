package android.appmvp.traiderapp.data.model

import android.appmvp.stockmarketapp.data.model.StockCardData

class StockCardStorage {

    fun getList() = listOf(
        StockCardData(
            1,
            "ticker1",
            "companyName1",
            "currentPrice1",
            "dayDeltaPrice1",
            "imageUrl"
        ),
        StockCardData(
            2,
            "ticker2",
            "companyName2",
            "currentPrice2",
            "dayDeltaPrice2",
            "imageUrl"
        ),
        StockCardData(
            3,
            "ticker2",
            "companyName2",
            "currentPrice2",
            "dayDeltaPrice2",
            "imageUrl"
        ),
        StockCardData(
            4,
            "ticker2",
            "companyName2",
            "currentPrice2",
            "dayDeltaPrice2",
            "imageUrl"
        ),
    )
}