package com.murphy.library.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.os.Build.VERSION_CODES.M
import android.view.LayoutInflater


abstract class BaseAdapter<M, VB: ViewDataBinding>(var mList: ArrayList<M>) : RecyclerView.Adapter<BaseViewHolder<VB>>() {

    var mItemClickListener: OnItemClickListener? = null
    var mItemLongClickListener: OnItemLongClickListener? = null
    var mLastItemClickPosition = RecyclerView.NO_POSITION


    abstract fun getLayoutId(type: Int) : Int
    abstract fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int, type: Int)
    final override fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int) {
        val type = getItemViewType(position)
        onBindViewHolder(holder, position, type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VB> {
        var binding : VB = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                getLayoutId(viewType), parent, false)
        var holder = BaseViewHolder(binding)
        if (mItemClickListener != null) {
            binding.root.setOnClickListener {
                val position = holder.adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    mLastItemClickPosition = position
                    mItemClickListener?.onItemClick(position)
                }
            }
        }

        if (mItemLongClickListener != null) {
            binding.root.setOnLongClickListener {
                val position = holder.adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    mItemLongClickListener?.onItemClick(position)
                }
                false
            }
        }
        return holder
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}