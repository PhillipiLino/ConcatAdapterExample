package com.phillipilino.concatadapterexample.viewHolders

import android.view.View
import com.phillipilino.concatadapterexample.BaseVH
import com.phillipilino.concatadapterexample.helpers.setVisible
import com.phillipilino.concatadapterexample.helpers.toCurrency
import com.phillipilino.concatadapterexample.models.FinancesItem
import kotlinx.android.synthetic.main.layout_item_finances.view.*

class ItemFinancesVH(view: View) : BaseVH<FinancesItem>(view) {
    fun bind(item: FinancesItem, position: Int, onItemPressed: ((View, FinancesItem, Int) -> Unit)?, isLastItem: Boolean) {
        super.bind(item, position, onItemPressed)
        if (position == 0) return
        view.view_divider_bottom.setVisible(isLastItem)
        view.txt_date.text = item.date
        view.txt_type.text = item.type
        view.txt_description.text = item.description
        view.txt_value.text = item.value.toCurrency()
    }
}