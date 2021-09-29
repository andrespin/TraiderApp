package android.appmvp.traiderapp.presentation.stockslist

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.SingleState

@StateStrategyType(AddToEndSingleStrategy::class)
interface StocksListView: MvpView {
    fun init()
    fun updateList()
}