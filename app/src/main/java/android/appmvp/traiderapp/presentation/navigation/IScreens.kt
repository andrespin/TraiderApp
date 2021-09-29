package android.appmvp.stockmarketapp.presentation.navigation

import android.appmvp.stockmarketapp.data.model.StockCardData
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun openStockDescFragment(data: StockCardData): Screen
    fun openStocksListFragment(): Screen
}
