package android.appmvp.traiderapp.presentation.stockslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.appmvp.traiderapp.StockMarketApp
import android.appmvp.traiderapp.arguments
import android.appmvp.stockmarketapp.presentation.stockslist.adapter.StocksAdapter
import android.appmvp.traiderapp.databinding.FragmentStocksListBinding
import android.appmvp.traiderapp.presentation.BackButtonListener
import android.content.res.XmlResourceParser
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class StocksListFragment : MvpAppCompatFragment(), StocksListView, BackButtonListener {

    private var vb: FragmentStocksListBinding? = null
    private var adapter: StocksAdapter? = null
    private lateinit var parser: XmlResourceParser

    private val presenter: StocksListPresenter by moxyPresenter {
        StocksListPresenter().apply {
            StockMarketApp.instance.initStocsListSubcomponent().inject(this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentStocksListBinding.inflate(inflater, container, false).also {
            vb = it
        }.root
    }

    companion object {
        fun newInstance() =
            StocksListFragment().arguments()
    }

    override fun init() {
        vb?.recyclerViewStocks?.layoutManager = LinearLayoutManager(requireContext())
        adapter = StocksAdapter(presenter.stocksListAdapterPresenter, requireContext()).apply {
            StockMarketApp.instance.appComponent.stocksListSubcomponent().inject(this)
        }
        vb?.recyclerViewStocks?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun backPressed() = presenter.backClick()

}


