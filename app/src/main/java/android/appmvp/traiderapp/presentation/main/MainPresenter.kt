package android.appmvp.traiderapp.presentation.main

import android.appmvp.stockmarketapp.presentation.navigation.IScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter() :
    MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.openStocksListFragment())
    }

    fun backClicked() {
        println("Main back")
        router.exit()
    }

}