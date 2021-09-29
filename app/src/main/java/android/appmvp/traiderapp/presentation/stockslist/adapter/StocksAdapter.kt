package android.appmvp.stockmarketapp.presentation.stockslist.adapter


import android.appmvp.traiderapp.presentation.stockslist.IStockItemView
import android.appmvp.stockmarketapp.presentation.stockslist.IStocksListAdapterPresenter
import android.appmvp.traiderapp.R
import android.appmvp.traiderapp.databinding.ItemStockBinding
import android.appmvp.traiderapp.presentation.stockslist.adapter.StocksViewHolder
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView


class StocksAdapter(
    private val presenter: IStocksListAdapterPresenter<IStockItemView>,
    private val fragmentContext: Context
) :
    RecyclerView.Adapter<StocksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StocksViewHolder =
        StocksViewHolder(
            ItemStockBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            fragmentContext
        ).apply {
            itemView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
            itemView.setOnLongClickListener {
                val pop = PopupMenu(itemView.context, it)
                pop.inflate(R.menu.context_menu)
                pop.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.action_addToFavourite -> {
                            presenter.itemFavoriteClickListener?.invoke(this)
                        }
                        R.id.action_deleteFromFavourite -> {
                            presenter.itemDeleteFromFavoriteClickListener?.invoke(this)
                        }
                    }
                    true
                }
                pop.show()
                println("Long click")
                true
            }
        }


    override fun onBindViewHolder(holder: StocksViewHolder, position: Int) {
        presenter.bindView(holder.apply {
            itemPosition = position
        })
    }

    override fun getItemCount(): Int = presenter.getCount()

}