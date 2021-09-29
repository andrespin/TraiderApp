package android.appmvp.traiderapp.presentation.stockslist.adapter


import android.appmvp.traiderapp.presentation.stockslist.IStockItemView
import android.appmvp.traiderapp.R
import android.appmvp.traiderapp.databinding.ItemStockBinding
import android.content.Context
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView

class StocksViewHolder(private val vb: ItemStockBinding, private val fragmentContext: Context) :
    RecyclerView.ViewHolder(vb.root),
    IStockItemView {

    override fun loadImage(url: String) {
        // TODO Загрузка картинки по ссылке
    }

    override fun setTicker(text: String) {
        vb.textTicker.text = text
    }

    override fun setCompanyName(text: String) {
        vb.textCompanyName.text = text
    }

    override fun setYellowStar() {
        vb.imageStar.background =
            AppCompatResources.getDrawable(
                fragmentContext,
                R.drawable.ic_star_yellow
            )
    }

    override fun setWhiteStar() {
        vb.imageStar.background =
            AppCompatResources.getDrawable(
                fragmentContext,
                R.drawable.ic_star_white
            )
    }

    override fun setCurrentPrice(text: String) {
        vb.textCurrentPrice.text = text
    }

    override fun setDayDelta(text: String) {
        vb.textDayDelta.text = text
    }

    override fun setBackgroundColorFirst() {
        vb.stockItemBackground.background =
            AppCompatResources.getDrawable(
                fragmentContext,
                R.drawable.rectangle_for_item_user_first
            )
    }

    override fun setBackgroundColorSecond() {
        vb.stockItemBackground.background =
            AppCompatResources.getDrawable(
                fragmentContext,
                R.drawable.rectangle_for_item_user_second
            )
    }

    override var itemPosition = -1

}
