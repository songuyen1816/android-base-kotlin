package com.bsp.basekotlin.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bsp.basekotlin.databinding.DialogLoadingBinding
import com.bsp.basekotlin.ui.base.BaseDialogFragment
import com.bsp.basekotlin.utils.extensions.setPercent

class LoadingDialog: BaseDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DialogLoadingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setPercent(100, 100)
    }

}