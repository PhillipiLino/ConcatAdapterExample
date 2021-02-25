package com.phillipilino.concatadapterexample.viewHolders

import android.view.View
import com.phillipilino.concatadapterexample.BaseVH
import com.phillipilino.concatadapterexample.helpers.setVisible
import kotlinx.android.synthetic.main.layout_item_button.view.*

class ItemButtonVH(view: View) : BaseVH<String>(view) {
    fun bind(item: String, position: Int, onItemPressed: ((View, String, Int) -> Unit)?, isLastButton: Boolean) {
        view.view_divider_bottom.setVisible(isLastButton)
        view.btn_item.text = item
        view.btn_item.setOnClickListener { onItemPressed?.invoke(view, item, position) }
    }
}