package android.appmvp.traiderapp.data.storage.cash

import android.appmvp.stockmarketapp.data.model.StockCardServerResponse
import android.appmvp.traiderapp.data.storage.RoomStockCard
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class RoomStockCardsCache: IRoomStockCardsCache {
    override fun getStockCard(id: String): Single<StockCardServerResponse> {
        TODO("Not yet implemented")
    }

    override fun putStockCard(roomStockCard: RoomStockCard): Completable {
        TODO("Not yet implemented")
    }
}