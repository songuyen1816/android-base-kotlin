package com.bsp.basekotlin

import android.app.Application
import android.content.Context
import com.bsp.basekotlin.utils.AppLog
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp: Application() {

    companion object {
        lateinit var instance: MyApp

        val applicationContext: Context
            get() = instance.applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        AppLog.initLogger(method = true, line = true)
    }
}