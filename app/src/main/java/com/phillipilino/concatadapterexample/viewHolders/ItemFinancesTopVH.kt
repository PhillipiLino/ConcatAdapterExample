package com.phillipilino.concatadapterexample.viewHolders

import android.view.View
import com.phillipilino.concatadapterexample.BaseVH
import com.phillipilino.concatadapterexample.R
import kotlinx.android.synthetic.main.layout_title_extrato.view.*

class ItemFinancesTopVH(view: View): BaseVH<Int>(view) {
    override fun bind(item: Int, position: Int, onItemPressed: ((View, Int, Int) -> Unit)?) {
        view.radio_group.setOnCheckedChangeListener { _, checkedId ->
            val days = when(checkedId) {
                R.id.radio_seven_days -> 7
                R.id.radio_fifteen_days -> 15
                R.id.radio_thirty_days -> 30
                R.id.radio_sixty_days -> 60
                else -> 0
            }

            onItemPressed?.invoke(view, days, position)
        }
    }
}