package android.appmvp.traiderapp.data.model

import android.appmvp.stockmarketapp.data.INetworkStatus
import android.appmvp.stockmarketapp.data.model.StockCardServerResponse
import android.appmvp.traiderapp.data.model.api.IDataSource
import io.reactivex.rxjava3.core.Single

class RetrofitStockCardsRepo(
    private val api: IDataSource,
    private val networkStatus: INetworkStatus
) : IStockCardsRepo {

    // TODO тут нужно добавить кеширование

    override fun getStockCurrentData(
        ticker: String,
        token: String,
        id: String
    ): Single<StockCardServerResponse> = api.getStockCurrentData(ticker, token)

    override fun getStockData(
        ticker: String,
        token: String,
        id: String
    ): Single<StockCardServerResponse> = api.getStockData(ticker, token)

}





