package com.phillipilino.concatadapterexample.viewHolders

import android.view.View
import com.phillipilino.concatadapterexample.BaseVH
import kotlinx.android.synthetic.main.layout_item_balance.view.*
import kotlinx.android.synthetic.main.layout_item_finances.view.txt_value

class ItemBalanceVH(view: View) : BaseVH<BalanceItem>(view) {
    override fun bind(item: BalanceItem, position: Int, onItemPressed: ((View, BalanceItem, Int) -> Unit)?) {
        super.bind(item, position, onItemPressed)
        view.txt_title.text = item.title
        view.txt_value.text = item.value.toCurrency()
    }
}

data class BalanceItem(
    val title: String,
    val value: Double
)