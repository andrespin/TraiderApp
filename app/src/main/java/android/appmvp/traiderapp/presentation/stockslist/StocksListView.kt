package android.appmvp.stockmarketapp.presentation.stockslist

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface StocksListView: MvpView {
    fun init()
    fun updateList()
}