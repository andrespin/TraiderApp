package android.appmvp.traiderapp.data.model.api

import android.appmvp.stockmarketapp.data.model.StockCardServerResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IDataSource {

    @GET("quote")
    fun getStockCurrentData(
        @Query("symbol") tickerSymbol: String,
        @Query("token") app_id: String
    ): Single<StockCardServerResponse>

    @GET("stock/profile2?")
    fun getStockData(
        @Query("symbol") tickerSymbol: String?,
        @Query("token") app_id: String?
    ): Single<StockCardServerResponse>

}