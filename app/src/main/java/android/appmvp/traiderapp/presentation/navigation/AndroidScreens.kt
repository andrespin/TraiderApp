package android.appmvp.stockmarketapp.presentation.navigation

import android.appmvp.stockmarketapp.data.model.StockCardData
import android.appmvp.stockmarketapp.presentation.stockdesc.StockDescFragment
import android.appmvp.stockmarketapp.presentation.stockslist.StocksListFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun openStockDescFragment(data: StockCardData): Screen =
        FragmentScreen { StockDescFragment.newInstance(data) }

    override fun openStocksListFragment(): Screen =
        FragmentScreen { StocksListFragment.newInstance() }
}


