package android.appmvp.traiderapp

import android.appmvp.traiderapp.data.model.RetrofitStockCardsRepo
import android.appmvp.traiderapp.data.model.api.IDataSource
import android.appmvp.traiderapp.data.network_status.INetworkStatus
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class RetrofitStockCardsRepoTest {

    private lateinit var repository: RetrofitStockCardsRepo

    private val token = "c4qbe32ad3icc97rfi60"

    @Mock
    private lateinit var api: IDataSource

    @Mock
    private lateinit var networkStatus: INetworkStatus

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repository = RetrofitStockCardsRepo(api, networkStatus)
    }

    @Test
    fun getStockCurrentData() {
        repository.getStockCurrentData("YNDX", token, "0")
        verify(api, times(1)).getStockCurrentData("YNDX", token)
    }

    @Test
    fun getStockDataTest() {
        repository.getStockData("YNDX", token, "0")
        verify(api, times(1)).getStockData("YNDX", token)
    }

}