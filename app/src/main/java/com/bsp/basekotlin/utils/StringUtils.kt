package com.bsp.basekotlin.utils

import com.bsp.basekotlin.MyApp

object StringUtils {

    fun getString(resId: Int, vararg formatArgs: Any):String{
        return MyApp.applicationContext.getString(resId, *formatArgs)
    }
}