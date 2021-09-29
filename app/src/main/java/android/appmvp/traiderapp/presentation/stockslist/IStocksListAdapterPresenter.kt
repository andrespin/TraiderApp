package android.appmvp.stockmarketapp.presentation.stockslist

interface IStocksListAdapterPresenter<V> {
    var itemClickListener: ((V) -> Unit)?
    var itemFavoriteClickListener: ((V) -> Unit)?
    var itemDeleteFromFavoriteClickListener: ((V) -> Unit)?
    var listChangeListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}