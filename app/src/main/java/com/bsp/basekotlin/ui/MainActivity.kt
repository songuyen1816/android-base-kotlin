package com.bsp.basekotlin.ui

import android.os.Bundle
import com.bsp.basekotlin.R
import com.bsp.basekotlin.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}