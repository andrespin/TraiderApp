package android.appmvp.stockmarketapp.presentation.stockdesc

import android.appmvp.stockmarketapp.data.model.StockCardData
import android.appmvp.stockmarketapp.presentation.navigation.AndroidScreens
import android.appmvp.stockmarketapp.presentation.navigation.IScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class StockDescPresenter() : MvpPresenter<StockDescView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()

    }

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    fun backClick(): Boolean {
        println("back StockDesk")
        router.exit()
        return true
    }

}