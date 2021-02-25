package com.phillipilino.concatadapterexample.helpers

import android.view.View

fun View.setVisible(visible: Boolean = true) {
    visibility = if (visible) View.VISIBLE else View.GONE
}