package android.appmvp.traiderapp

import android.appmvp.traiderapp.data.model.StockCardServerResponse
import android.appmvp.traiderapp.data.storage.RoomStockCard
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

fun Fragment.arguments(vararg arguments: Pair<String, Any>): Fragment {
    this.arguments = bundleOf(*arguments)
    return this
}

fun convertFromServerResponseToRoom(
    serverResponse: StockCardServerResponse,
    id: String,
    ticker: String
) = RoomStockCard(
    id,
    ticker,
    serverResponse.name,
    serverResponse.currentPrice.toString(),
    ((serverResponse.currentPrice ?: 0.0) - (serverResponse.previousClosePrice ?: 0.0)).toString(),
    serverResponse.logoURL,

    serverResponse.openPriceOfTheDay,
    serverResponse.highPriceOfTheDay,
    serverResponse.lowPriceOfTheDay,
    serverResponse.currentPrice,
    serverResponse.previousClosePrice,
    serverResponse.logoURL,
    serverResponse.name
)

fun convertFromRoomToServerResponse(room: RoomStockCard) =
    StockCardServerResponse(
        room.s_openPriceOfTheDay,
        room.s_highPriceOfTheDay,
        room.s_lowPriceOfTheDay,
        room.s_currentPrice,
        room.s_previousClosePrice,
        room.s_logoURL,
        room.s_name
    )






