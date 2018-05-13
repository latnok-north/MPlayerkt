package com.murphy.library.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View

open class BaseViewHolder<VB : ViewDataBinding> : RecyclerView.ViewHolder {

    protected lateinit var mBinding: VB

    constructor(vb : VB) : super(vb.root) {
        mBinding = vb
    }

    fun getBinding() : VB {
        return mBinding
    }

}