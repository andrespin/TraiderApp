package android.appmvp.traiderapp.data.di.stockslist

import android.appmvp.stockmarketapp.presentation.stockslist.StocksListPresenter
import android.appmvp.stockmarketapp.presentation.stockslist.adapter.StocksAdapter
import dagger.Subcomponent


@StocksListScope
@Subcomponent(
    modules = [
        StocksListModule::class
    ]
)
interface StocksListSubcomponent {

    fun inject(stocksListPresenter: StocksListPresenter)
    fun inject(stocksAdapter: StocksAdapter)

}