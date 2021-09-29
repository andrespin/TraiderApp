package android.appmvp.traiderapp.data.storage

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RoomStockCard(
    @PrimaryKey var id: String,
    var ticker: String?,
    var companyName: String?,
    var currentPrice: String?,
    var dayDeltaPrice: String?,
    var imageUrl: String?,

    val s_openPriceOfTheDay: Double?,
    val s_highPriceOfTheDay: Double?,
    var s_lowPriceOfTheDay: Double?,
    var s_currentPrice: Double?,
    var s_previousClosePrice: Double?,
    var s_logoURL: String?,
    var s_name: String?
)