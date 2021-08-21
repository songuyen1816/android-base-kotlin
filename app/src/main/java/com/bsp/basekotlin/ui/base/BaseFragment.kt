package com.bsp.basekotlin.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.bsp.basekotlin.utils.Event

abstract class BaseFragment<DB : ViewDataBinding> : Fragment() {

    private var baseActivity: BaseActivity? = null
    private var isFirst: Boolean = true
    lateinit var binding: DB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!this::binding.isInitialized) {
            binding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        }
        if (binding.root.parent != null) {
            (binding.root.parent as ViewGroup).removeView(binding.root)
        }
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        createObserver()
    }

    abstract fun layoutId(): Int
    abstract fun setupViews()
    abstract fun createObserver()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        baseActivity = context as BaseActivity
    }

    protected fun handleLoading(event: Event<Boolean>) {
        event.getContentIfNotHandled()?.let {
            baseActivity?.handleLoading(it)
        }
    }

    protected fun handleLoading(isLoading: Boolean) {
        baseActivity?.handleLoading(isLoading)
    }

    protected fun showLoading() {
        baseActivity?.showLoading()
    }

    protected fun hideLoading() {
        baseActivity?.hideLoading()
    }
}