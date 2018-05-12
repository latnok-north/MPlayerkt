package com.murphy.library.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<VB : ViewDataBinding> : RecyclerView.ViewHolder {

    protected lateinit var mBinding: VB
    constructor(view: View) : super(view) {
        mBinding = DataBindingUtil.bind(view)
    }
}