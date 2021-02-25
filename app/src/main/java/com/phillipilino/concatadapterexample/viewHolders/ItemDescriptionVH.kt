package com.phillipilino.concatadapterexample.viewHolders

import android.text.Html
import android.view.View
import com.phillipilino.concatadapterexample.BaseVH
import kotlinx.android.synthetic.main.layout_item_description.view.*
import kotlinx.android.synthetic.main.layout_item_transfer.view.*

class ItemDescriptionVH(view: View) : BaseVH<String>(view) {
    override fun bind(item: String, position: Int, onItemPressed: ((View, String, Int) -> Unit)?) {
        super.bind(item, position, onItemPressed)
        view.txt_info.text = Html.fromHtml(item)
    }
}