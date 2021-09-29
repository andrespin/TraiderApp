package android.appmvp.stockmarketapp.presentation.stockslist


import android.appmvp.stockmarketapp.data.model.StockCardData
import android.appmvp.stockmarketapp.presentation.navigation.IScreens
import android.appmvp.traiderapp.data.di.stockslist.ISourcesGetter
import android.appmvp.traiderapp.data.model.StockCardStorage
import android.appmvp.traiderapp.presentation.stockslist.IStockItemView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import org.xmlpull.v1.XmlPullParser
import javax.inject.Inject

class StocksListPresenter() : MvpPresenter<StocksListView>() {

    class StocksListAdapterPresenter() : IStocksListAdapterPresenter<IStockItemView> {

        val stocksList = mutableListOf<StockCardData>()

        val favoriteList = mutableListOf<Int>()

        override var itemClickListener: ((IStockItemView) -> Unit)? = null

        override var itemFavoriteClickListener: ((IStockItemView) -> Unit)? = null

        override var itemDeleteFromFavoriteClickListener: ((IStockItemView) -> Unit)? = null

        override var listChangeListener: ((IStockItemView) -> Unit)? = null

        override fun bindView(view: IStockItemView) {
            view.setCompanyName(stocksList[view.itemPosition].companyName ?: "")
            view.setDayDelta(stocksList[view.itemPosition].dayDeltaPrice ?: "")
            view.setCurrentPrice(stocksList[view.itemPosition].currentPrice ?: "")
            view.setTicker(stocksList[view.itemPosition].ticker ?: "")
            // view.loadImage(stocksList[view.itemPosition].imageUrl ?: "")
            putYellowStarIfFavorite(view)
            setBackground(view)
        }

        private fun putYellowStarIfFavorite(view: IStockItemView) {
            println("putYellowStarIfFavorite")
            if (favoriteList.contains(view.itemPosition)) {
                println("favoriteList = " + favoriteList)
                view.setYellowStar()
            } else {
                view.setWhiteStar()
            }
        }

        override fun getCount(): Int = stocksList.size

        private fun setBackground(view: IStockItemView) {
            if (view.itemPosition % 2 == 0) {
                view.setBackgroundColorFirst()
            } else {
                view.setBackgroundColorSecond()
            }
        }
    }

    val stocksListAdapterPresenter = StocksListAdapterPresenter()

    @Inject
    lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        println("getTickers() = " + getTickers())
        stocksListAdapterPresenter.itemClickListener = { view ->
            val stockCardData = stocksListAdapterPresenter.stocksList[view.itemPosition]
            router.navigateTo(screens.openStockDescFragment(stockCardData))
            println("Click")
        }

        stocksListAdapterPresenter.itemFavoriteClickListener = { view ->
            stocksListAdapterPresenter.favoriteList.add(view.itemPosition)
            stocksListAdapterPresenter.bindView(view)
        }

        stocksListAdapterPresenter.itemDeleteFromFavoriteClickListener = { view ->
            stocksListAdapterPresenter.favoriteList.remove(view.itemPosition)
            stocksListAdapterPresenter.bindView(view)
        }

    }

    @Inject
    lateinit var resourcesScopeContainer: ISourcesGetter

    private fun getTickers(): List<String> {
        val parser = resourcesScopeContainer.getSources()
        val list = mutableListOf<String>()
        while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
            if (parser.getEventType() == XmlPullParser.START_TAG
                && parser.getName().equals("ticker")
            ) {
                list.add(
                    parser.getAttributeValue(0)
                )
            }
            parser.next();
        }
        return list
    }

    @Inject
    lateinit var uiScheduler: Scheduler

    private fun loadData() {
        stocksListAdapterPresenter.stocksList.clear()
        stocksListAdapterPresenter.stocksList.addAll(StockCardStorage().getList())
    }

    @Inject
    lateinit var router: Router

    fun backClick(): Boolean {
        println("back StockList")
        router.exit()
        return true
    }

}