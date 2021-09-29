package android.appmvp.traiderapp

import android.app.Application
import android.appmvp.traiderapp.data.di.AppComponent
import android.appmvp.traiderapp.data.di.AppModule
import android.appmvp.traiderapp.data.di.DaggerAppComponent
import android.appmvp.traiderapp.data.di.stockdesc.StockDescSubcomponent
import android.appmvp.traiderapp.data.di.stockslist.ISourcesGetter
import android.appmvp.traiderapp.data.di.stockslist.IStocksListScopeContainer
import android.appmvp.traiderapp.data.di.stockslist.StocksListSubcomponent
import android.content.res.XmlResourceParser


class StockMarketApp : Application(), IStocksListScopeContainer, ISourcesGetter {

    lateinit var appComponent: AppComponent


    var stocksListSubcomponent: StocksListSubcomponent? = null

    var stocksDescSubcomponent: StockDescSubcomponent? = null

    companion object {
        lateinit var instance: StockMarketApp
    }


    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    fun initStocsListSubcomponent() = appComponent.stocksListSubcomponent().also {
        stocksListSubcomponent = it
    }

    fun initStocDescSubcomponent() = appComponent.stockDescSubcomponent().also {
        stocksDescSubcomponent = it
    }

    override fun releaseStocksListScope() {
        stocksListSubcomponent = null
    }

    override fun getSources(): XmlResourceParser = resources.getXml(R.xml.tickers)

}