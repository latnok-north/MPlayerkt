package com.murphy.library.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

/**
 * Created by murphy on 2018/3/31.
 */

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity () {

    abstract fun onBaseCreate(savedInstanceState: Bundle?)
    abstract val layoutId: Int
    protected lateinit var mBinding: VB
    protected var viewModel: VM? = null
    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, layoutId)
        viewModel = initViewModel()
        onBaseCreate(savedInstanceState)
    }

    abstract fun initViewModel(): VM

    protected fun supportActionBar(toolbar: Toolbar): ActionBar? {
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
        }
        return actionBar
    }
}