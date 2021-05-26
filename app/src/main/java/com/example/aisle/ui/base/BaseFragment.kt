package com.example.aisle.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.aisle.utils.autoCleared

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> : Fragment() {

    private var mViewDataBinding by autoCleared<T>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<T>(inflater, getLayoutId(), container, false).also {
        mViewDataBinding = it
        mViewDataBinding.setVariable(getBindingVariable(), getViewModel())
        mViewDataBinding.lifecycleOwner = viewLifecycleOwner
        mViewDataBinding.executePendingBindings()
    }.root

    fun showMessage(message: String) {
        (requireActivity() as BaseActivity).showMessage(message)
    }

    fun showMessage(stringRes: Int) {
        (requireActivity() as BaseActivity).showMessage(stringRes)
    }

    fun showLoading(visible: Boolean) {
        if (visible)
            (requireActivity() as BaseActivity).showLoading(visible)
        else
            (requireActivity() as BaseActivity).hideLoading()
    }

    fun showAlert(message: String) {
        (requireActivity() as BaseActivity).showAlert(message)
    }

    fun showAlert(message: Int) {
        (requireActivity() as BaseActivity).showAlert(message)
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getBindingVariable(): Int

    abstract fun getViewModel(): V

    fun getViewDataBinding() = mViewDataBinding
}