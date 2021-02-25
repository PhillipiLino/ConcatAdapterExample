package com.phillipilino.concatadapterexample.viewHolders

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import com.phillipilino.concatadapterexample.BaseVH
import com.phillipilino.concatadapterexample.R
import com.phillipilino.concatadapterexample.setVisible
import kotlinx.android.synthetic.main.layout_item_transfer.view.*
import java.text.NumberFormat
import java.util.*

class ItemTransferVH(private val context: Context, view: View) : BaseVH<TransferItem>(view) {
    override fun bind(item: TransferItem, position: Int, onItemPressed: ((View, TransferItem, Int) -> Unit)?) {
        super.bind(item, position, onItemPressed)
        val colorRes = if (item.value >= 0) R.color.dayconnect_green else R.color.dayconnect_red
        val color = context.getColorHelper(colorRes)

        val indicatorRes = if (item.value >= 0) R.drawable.ic_plus else R.drawable.ic_minus

        view.view_indicator_value.setBackgroundColor(color)
        view.img_icon_value.setColorFilter(color, android.graphics.PorterDuff.Mode.SRC_IN)
        view.img_icon_value.setImageResource(indicatorRes)
        view.txt_value.setTextColor(color)

        view.txt_date.text = item.date
        view.txt_title.text = item.title
        view.txt_description.text = item.description
        view.txt_value.text = item.value.toCurrency()

        view.txt_description.setVisible(item.description.isNotEmpty())
    }
}

data class TransferItem(
    val date: String,
    val title: String,
    val description: String,
    val value: Double,
)

fun Context.getColorHelper(id: Int): Int =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) resources.getColor(id, null)
    else resources.getColor(id)

fun Context.getDrawableHelper(id: Int): Drawable =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) resources.getDrawable(id, null)
    else resources.getDrawable(id)

fun Double.toCurrency(language: String = "pt", country: String = "BR"): String {
    val formatter = NumberFormat.getCurrencyInstance(Locale(language, country))
    val currencySymbol = formatter.currency?.symbol ?: "R$"
    return formatter.format(this).replace(currencySymbol, " $currencySymbol ")
}