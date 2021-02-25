package com.phillipilino.concatadapterexample.adapters

import android.view.View
import com.phillipilino.concatadapterexample.BaseAdapter
import com.phillipilino.concatadapterexample.BaseVH
import com.phillipilino.concatadapterexample.R
import com.phillipilino.concatadapterexample.models.FinancesItem
import com.phillipilino.concatadapterexample.viewHolders.ItemFinancesVH

class ItemFinancesAdapter: BaseAdapter<FinancesItem>() {
    override fun getLayoutId(position: Int, obj: FinancesItem) = when(position) {
        0 -> R.layout.layout_title_finances
        else -> R.layout.layout_item_finances
    }

    override fun getViewHolder(view: View, viewType: Int) =
        ItemFinancesVH(view)

    override fun onBindViewHolder(holder: BaseVH<FinancesItem>, position: Int) =
        (holder as ItemFinancesVH).bind(items[position], position, onItemPressed, (position == itemCount - 1))

    override fun loadItems(items: List<FinancesItem>, onItemPressed: ((View, FinancesItem, Int) -> Unit)?) {
        val list = items.toMutableList()
        list.add(0,
            FinancesItem(
                "",
                "",
                "",
                0.0
            )
        )
        super.loadItems(list, onItemPressed)
    }
}