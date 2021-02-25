package com.phillipilino.concatadapterexample.adapters

import android.view.View
import com.phillipilino.concatadapterexample.BaseAdapter
import com.phillipilino.concatadapterexample.BaseVH
import com.phillipilino.concatadapterexample.R
import com.phillipilino.concatadapterexample.viewHolders.ItemButtonVH

class ItemButtonAdapter: BaseAdapter<String>() {
    override fun getLayoutId(position: Int, obj: String) =
        R.layout.layout_item_button
    override fun getViewHolder(view: View, viewType: Int) =
        ItemButtonVH(view)
    override fun onBindViewHolder(holder: BaseVH<String>, position: Int) =
        (holder as ItemButtonVH).bind(items[position], position, onItemPressed, (position == itemCount - 1))
}