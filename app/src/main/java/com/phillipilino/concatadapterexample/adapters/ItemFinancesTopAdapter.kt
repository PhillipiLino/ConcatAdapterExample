package com.phillipilino.concatadapterexample.adapters

import android.view.View
import com.phillipilino.concatadapterexample.BaseAdapter
import com.phillipilino.concatadapterexample.R
import com.phillipilino.concatadapterexample.viewHolders.ItemFinancesTopVH

class ItemFinancesTopAdapter: BaseAdapter<Int>() {
    override fun getLayoutId(position: Int, obj: Int) =
        R.layout.layout_title_extrato
    override fun getViewHolder(view: View, viewType: Int) =
        ItemFinancesTopVH(view)

    fun init(onItemPressed: ((View, Int, Int) -> Unit)?) = loadItems(listOf(0), onItemPressed)
}