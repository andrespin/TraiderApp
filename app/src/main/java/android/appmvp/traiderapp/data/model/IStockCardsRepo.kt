package android.appmvp.traiderapp.data.model

import android.appmvp.stockmarketapp.data.model.StockCardServerResponse
import io.reactivex.rxjava3.core.Single

interface IStockCardsRepo {
    fun getStockCurrentData(ticker: String, token: String, id: String): Single<StockCardServerResponse>
    fun getStockData(ticker: String, token: String, id: String): Single<StockCardServerResponse>
}