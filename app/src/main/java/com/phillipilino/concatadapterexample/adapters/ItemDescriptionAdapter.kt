package com.phillipilino.concatadapterexample.adapters

import android.view.View
import com.phillipilino.concatadapterexample.BaseAdapter
import com.phillipilino.concatadapterexample.R
import com.phillipilino.concatadapterexample.viewHolders.ItemDescriptionVH

class ItemDescriptionAdapter: BaseAdapter<String>() {
    override fun getLayoutId(position: Int, obj: String) =
        R.layout.layout_item_description
    override fun getViewHolder(view: View, viewType: Int) =
        ItemDescriptionVH(view)
}