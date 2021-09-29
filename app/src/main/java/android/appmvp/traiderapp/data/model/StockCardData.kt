package android.appmvp.stockmarketapp.data.model

import android.os.Parcel
import android.os.Parcelable

data class StockCardData(
    var id: Int,
    var ticker: String?,
    var companyName: String?,
    var currentPrice: String?,
    var dayDeltaPrice: String?,
    var imageUrl: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(ticker)
        parcel.writeString(companyName)
        parcel.writeString(currentPrice)
        parcel.writeString(dayDeltaPrice)
        parcel.writeString(imageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StockCardData> {
        override fun createFromParcel(parcel: Parcel): StockCardData {
            return StockCardData(parcel)
        }

        override fun newArray(size: Int): Array<StockCardData?> {
            return arrayOfNulls(size)
        }
    }
}
