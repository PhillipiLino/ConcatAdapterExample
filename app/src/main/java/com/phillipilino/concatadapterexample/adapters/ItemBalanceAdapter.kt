package com.phillipilino.concatadapterexample.adapters

import android.view.View
import com.phillipilino.concatadapterexample.BaseAdapter
import com.phillipilino.concatadapterexample.R
import com.phillipilino.concatadapterexample.viewHolders.BalanceItem
import com.phillipilino.concatadapterexample.viewHolders.ItemBalanceVH

class ItemBalanceAdapter: BaseAdapter<BalanceItem>() {
    override fun getLayoutId(position: Int, obj: BalanceItem) = when(position) {
        0 -> R.layout.layout_title_balance
        else -> R.layout.layout_item_balance
    }

    override fun getViewHolder(view: View, viewType: Int) =
        ItemBalanceVH(view)
}