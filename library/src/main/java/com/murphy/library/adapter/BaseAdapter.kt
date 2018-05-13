package com.murphy.library.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.os.Build.VERSION_CODES.M
import android.view.LayoutInflater


abstract class BaseAdapter<M>(private val mContext: Context, var mList: ArrayList<M>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var mItemClickListener: OnItemClickListener? = null
    var mItemLongClickListener: OnItemLongClickListener? = null
    var mLastItemClickPosition = RecyclerView.NO_POSITION

    abstract fun getLayoutId(type: Int) : Int

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        var binding : ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
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