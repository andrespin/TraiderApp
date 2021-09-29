package android.appmvp.traiderapp.presentation.stockslist

interface IStockItemView {
    fun loadImage(url: String)
    fun setTicker(text: String)
    fun setCompanyName(text: String)
    fun setYellowStar()
    fun setWhiteStar()
    fun setCurrentPrice(text: String)
    fun setDayDelta(text: String)
    fun setBackgroundColorFirst()
    fun setBackgroundColorSecond()
    var itemPosition: Int
}