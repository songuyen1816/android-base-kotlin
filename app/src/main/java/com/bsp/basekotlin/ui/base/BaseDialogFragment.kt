package com.bsp.basekotlin.ui.base

import android.app.Dialog
import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.bsp.basekotlin.R
import com.bsp.basekotlin.utils.KeyboardUtils
import java.util.*

abstract class BaseDialogFragment: DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.BaseDialog)
    }

    fun show(fragmentManager: FragmentManager){
        show(fragmentManager, "${UUID.randomUUID()}")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return object : Dialog(requireContext(), theme){
            override fun dispatchTouchEvent(event: MotionEvent): Boolean {
                if (event.action == MotionEvent.ACTION_DOWN) {
                    val current = currentFocus
                    val outRect = Rect()
                    current?.let {
                        current.getGlobalVisibleRect(outRect)

                        if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                            if (it is AppCompatEditText) {
                                current.clearFocus()
                                KeyboardUtils.dismissKeyboard(requireContext(), it)
                            }
                        }
                    }
                }
                return super.dispatchTouchEvent(event)
            }
        }
    }
}