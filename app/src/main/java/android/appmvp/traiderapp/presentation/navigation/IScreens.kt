package android.appmvp.traiderapp.presentation.navigation

import android.appmvp.traiderapp.data.model.StockCardData
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun openStockDescFragment(data: StockCardData): Screen
    fun openStocksListFragment(): Screen
}
