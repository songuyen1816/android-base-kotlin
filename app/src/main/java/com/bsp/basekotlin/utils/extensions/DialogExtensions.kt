package com.bsp.basekotlin.utils.extensions

import android.content.res.Resources
import android.graphics.Rect
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

fun DialogFragment.setWidthPercent(percentage: Int) {
    val percent = percentage.toFloat() / 100
    val dm = Resources.getSystem().displayMetrics
    val rect = dm.run { Rect(0, 0, widthPixels, heightPixels) }
    val percentWidth = rect.width() * percent
    dialog?.window?.setLayout(percentWidth.toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
}

fun DialogFragment.setPercent(widthPercent: Int, heightPercent: Int) {
    val width = widthPercent.toFloat() / 100
    val height = heightPercent.toFloat() / 100
    val dm = Resources.getSystem().displayMetrics

    val rect = dm.run { Rect(0, 0, widthPixels, heightPixels) }

    val percentWidth = rect.width() * width
    val percentHeight = rect.height() * height
    dialog?.window?.setLayout(percentWidth.toInt(), percentHeight.toInt())
}