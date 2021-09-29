package android.appmvp.stockmarketapp.presentation.stockdesc

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface StockDescView: MvpView {
    fun init()
}