package android.appmvp.traiderapp

import android.appmvp.traiderapp.presentation.stockslist.StocksListPresenter
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class StocksListPresenterTest {

    private lateinit var presenter: StocksListPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = StocksListPresenter()
    }

    @Test
    fun backClickTest() {
        presenter.backClick()
        verify(times(1))
    }

}