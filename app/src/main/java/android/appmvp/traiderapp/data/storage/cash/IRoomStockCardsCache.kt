package android.appmvp.traiderapp.data.storage.cash

import android.appmvp.traiderapp.data.model.StockCardServerResponse
import android.appmvp.traiderapp.data.storage.RoomStockCard
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface IRoomStockCardsCache {
    fun getStockCard(id: String): Single<StockCardServerResponse>
    fun putStockCard(roomStockCard: RoomStockCard): Completable
}