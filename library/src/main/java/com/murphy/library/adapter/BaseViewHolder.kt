package com.murphy.library.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

open class BaseViewHolder<VB : ViewDataBinding>(vb: VB) : RecyclerView.ViewHolder(vb.root) {

    var mBinding: VB = vb

    fun getBinding() : VB {
        return mBinding
    }

}