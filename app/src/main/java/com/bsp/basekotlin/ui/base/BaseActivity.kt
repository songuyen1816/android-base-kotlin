package com.bsp.basekotlin.ui.base

import android.graphics.Rect
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.bsp.basekotlin.ui.dialog.LoadingDialog
import com.bsp.basekotlin.utils.Event
import com.bsp.basekotlin.utils.KeyboardUtils
import dagger.hilt.android.AndroidEntryPoint

open class BaseActivity : AppCompatActivity() {

    private var loadingDialog: LoadingDialog? = null

    fun handleLoading(event: Event<Boolean>) {
        event.getContentIfNotHandled()?.let {
            handleLoading(it)
        }
    }

    fun handleLoading(loading: Boolean) {
        if (loading) showLoading() else hideLoading()
    }

    fun hideLoading() {
        if (loadingDialog != null) {
            loadingDialog?.dismiss()
            loadingDialog = null
        }
    }

    fun showLoading() {
        if(loadingDialog != null){
            loadingDialog!!.dismiss()
        }
        loadingDialog = LoadingDialog()
        loadingDialog!!.show(supportFragmentManager)
    }


    /** Dismiss keyboard when touch outside edittext **/
    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val current = currentFocus
            val outRect = Rect()

            current?.let {
                current.getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    if (it is AppCompatEditText) {
                        current.clearFocus()
                        KeyboardUtils.dismissKeyboard(this, it)
                    }
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }

}