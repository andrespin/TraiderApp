package android.appmvp.stockmarketapp.presentation.stockdesc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.appmvp.traiderapp.StockMarketApp
import android.appmvp.traiderapp.arguments
import android.appmvp.stockmarketapp.data.model.StockCardData
import android.appmvp.traiderapp.databinding.FragmentStockDescBinding
import android.appmvp.traiderapp.presentation.BackButtonListener
import android.appmvp.traiderapp.presentation.stockdesc.StockDescView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class StockDescFragment : MvpAppCompatFragment(), StockDescView, BackButtonListener {

    private var vb: FragmentStockDescBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("StockDescFragment start")
        return FragmentStockDescBinding.inflate(inflater, container, false).also {
            vb = it
        }.root
    }

    private val presenter: StockDescPresenter by moxyPresenter {
        StockDescPresenter().apply {
            StockMarketApp.instance.initStocDescSubcomponent().inject(this)
        }
    }

    companion object {

        private const val ID = "id"

        fun newInstance(data: StockCardData) =
            StockDescFragment().arguments(ID to data)
    }

    private val stockCardData: StockCardData by lazy {
        arguments?.getParcelable<StockCardData>(ID) as StockCardData
    }

    override fun init() {
        vb?.textView?.text = "ticker: ${stockCardData.ticker}\n " +
                "companyName: ${stockCardData.companyName}\n " +
                "currentPrice: ${stockCardData.currentPrice}\n " +
                "dayDeltaPrice: ${stockCardData.dayDeltaPrice}\n" +
                "imageUrl:  ${stockCardData.dayDeltaPrice}"
    }

    override fun backPressed() = presenter.backClick()

}