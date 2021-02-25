package com.phillipilino.concatadapterexample.adapters

import android.content.Context
import android.view.View
import com.phillipilino.concatadapterexample.BaseAdapter
import com.phillipilino.concatadapterexample.R
import com.phillipilino.concatadapterexample.viewHolders.ItemTransferVH
import com.phillipilino.concatadapterexample.viewHolders.TransferItem

class ItemTransferAdapter(private val context: Context): BaseAdapter<TransferItem>() {
    override fun getLayoutId(position: Int, obj: TransferItem) =
        R.layout.layout_item_transfer
    override fun getViewHolder(view: View, viewType: Int) =
        ItemTransferVH(context, view)
}

