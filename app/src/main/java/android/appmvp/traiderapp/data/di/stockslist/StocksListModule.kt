package android.appmvp.traiderapp.data.di.stockslist

import android.appmvp.traiderapp.StockMarketApp
import dagger.Module
import dagger.Provides

@Module
class StocksListModule {

//    @StocksListScope
//    @Provides
//    fun stockCardsCache(database: Database1): IRoomStockCardsCache = RoomStockCardsCache(database)
//
//    @StocksListScope
//    @Provides
//    fun favoriteStockCache(database: Database1): IRoomFavoriteStockCache =
//        RoomFavoriteStockCache(database)

//    @StocksListScope
//    @Provides
//    fun stockCardsRepo(
//        api: IDataSource,
//        networkStatus: INetworkStatus,
//        cache: IRoomStockCardsCache
//    ): IStockCardsRepo =
//        RetrofitStockCardsRepo(api, networkStatus, cache)

    @StocksListScope
    @Provides
    fun stockCardScopeContainer(app: StockMarketApp): IStocksListScopeContainer = app

    @StocksListScope
    @Provides
    fun resourcesScopeContainer(app: StockMarketApp): ISourcesGetter = app

//    @StocksListScope
//    @Provides
//    fun getDatabase(app: StockMarketApp): IDatabase = app

}