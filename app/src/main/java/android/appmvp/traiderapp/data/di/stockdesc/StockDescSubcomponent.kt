package android.appmvp.traiderapp.data.di.stockdesc

import android.appmvp.traiderapp.data.di.stockslist.StocksListScope
import android.appmvp.traiderapp.presentation.stockdesc.StockDescPresenter
import dagger.Subcomponent


@StocksListScope
@Subcomponent(
    modules = [
        StockDescModule::class
    ]
)
interface StockDescSubcomponent {
    fun inject(stockDescPresenter: StockDescPresenter)
}


