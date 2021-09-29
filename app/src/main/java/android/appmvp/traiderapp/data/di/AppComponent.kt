package android.appmvp.traiderapp.data.di

import android.appmvp.traiderapp.data.di.stockdesc.StockDescSubcomponent
import android.appmvp.traiderapp.data.di.stockslist.StocksListSubcomponent
import android.appmvp.traiderapp.presentation.main.MainActivity
import android.appmvp.traiderapp.presentation.main.MainPresenter
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        CiceroneModule::class,
        SchedulerModule::class,
        ApiModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent {
    fun stocksListSubcomponent(): StocksListSubcomponent
    fun stockDescSubcomponent(): StockDescSubcomponent

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
}

