package android.appmvp.traiderapp.presentation.navigation

import android.appmvp.traiderapp.data.model.StockCardData
import android.appmvp.traiderapp.presentation.stockdesc.StockDescFragment
import android.appmvp.traiderapp.presentation.stockslist.StocksListFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun openStockDescFragment(data: StockCardData): Screen =
        FragmentScreen { StockDescFragment.newInstance(data) }

    override fun openStocksListFragment(): Screen =
        FragmentScreen { StocksListFragment.newInstance() }
}


