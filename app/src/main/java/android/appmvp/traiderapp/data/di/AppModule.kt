package android.appmvp.traiderapp.data.di

import android.appmvp.traiderapp.StockMarketApp
import dagger.Module
import dagger.Provides

@Module
class AppModule(val app: StockMarketApp) {

    @Provides
    fun app(): StockMarketApp = app

}