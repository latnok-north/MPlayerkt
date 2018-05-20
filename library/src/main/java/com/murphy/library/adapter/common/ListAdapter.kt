package com.murphy.library.adapter.common

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import com.murphy.library.adapter.IAdapterView
import com.murphy.library.adapter.OnItemClickListener
import com.murphy.library.adapter.OnItemLongClickListener

/**
 * Created by murphy on 2018/4/1.
 */
abstract class ListAdapter<T, out V : IAdapterView<T>>(private val mContext: Context, var mList: ArrayList<T>) : RecyclerView.Adapter<ViewHolder>() {

    var mItemClickListener: OnItemClickListener? = null
    var mItemLongClickListener: OnItemLongClickListener? = null
    var mLastItemClickPosition = RecyclerView.NO_POSITION

    abstract fun createView(context: Context, viewType: Int): V

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = createView(mContext, viewType) as View
        val holder = object : RecyclerView.ViewHolder(itemView) {}
        if (mItemClickListener != null) {
            itemView.setOnClickListener {
                val position = holder.adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    mLastItemClickPosition = position
                    mItemClickListener?.onItemClick(position)
                }
            }
        }

        if (mItemLongClickListener != null) {
            itemView.setOnLongClickListener {
                val position = holder.adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    mItemLongClickListener?.onItemClick(position)
                }
                false
            }
        }
        return holder
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val itemView = holder.itemView as? V
        itemView?.bind(getItem(position), position)
    }

    fun setData(data: ArrayList<T>) {
        mList = data
    }

    fun addData(data: ArrayList<T>) {
        mList.addAll(data)
    }

    fun getData(): ArrayList<T> {
        return mList
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    open fun getItem(position: Int): T? {
        return mList[position]
    }

    fun getItemLongClickListener(): OnItemLongClickListener? {
        return mItemLongClickListener
    }

    fun setOnItemLongClickListener(listener: OnItemLongClickListener) {
        mItemLongClickListener = listener
    }

    fun getItemClickListener(): OnItemClickListener? {
        return mItemClickListener
    }

    fun getLastItemClickPosition(): Int {
        return mLastItemClickPosition
    }

}