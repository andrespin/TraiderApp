package android.appmvp.traiderapp.data.di.stockslist

import android.appmvp.stockmarketapp.data.INetworkStatus
import android.appmvp.traiderapp.StockMarketApp
import android.appmvp.traiderapp.data.model.IStockCardsRepo
import android.appmvp.traiderapp.data.model.RetrofitStockCardsRepo
import android.appmvp.traiderapp.data.model.api.IDataSource
import android.appmvp.traiderapp.data.storage.cash.IRoomStockCardsCache
import dagger.Module
import dagger.Provides

@Module
class StocksListModule {


    @StocksListScope
    @Provides
    fun stockCardsRepo(
        api: IDataSource,
        networkStatus: INetworkStatus
    ): IStockCardsRepo =
        RetrofitStockCardsRepo(api, networkStatus)

    @StocksListScope
    @Provides
    fun stockCardScopeContainer(app: StockMarketApp): IStocksListScopeContainer = app

    @StocksListScope
    @Provides
    fun resourcesScopeContainer(app: StockMarketApp): ISourcesGetter = app


}