package com.murphy.library.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

open class BaseViewHolder<VB : ViewDataBinding>(vb: VB) : RecyclerView.ViewHolder(vb.root) {

    companion object {
        fun <VB : ViewDataBinding> create(parent: ViewGroup, layoutId: Int) : BaseViewHolder<VB> {
            val binding : VB = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                    layoutId, parent, false)
            return BaseViewHolder(binding)
        }
    }



    var mBinding: VB = vb

    fun getBinding() : VB {
        return mBinding
    }

}