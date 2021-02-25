package com.phillipilino.concatadapterexample.helpers

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build

fun Context.getColorHelper(id: Int): Int =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) resources.getColor(id, null)
    else resources.getColor(id)

fun Context.getDrawableHelper(id: Int): Drawable =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) resources.getDrawable(id, null)
    else resources.getDrawable(id)