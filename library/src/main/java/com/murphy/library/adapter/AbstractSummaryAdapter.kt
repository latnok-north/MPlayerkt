package com.murphy.library.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.murphy.library.adapter.common.ListAdapter

/**
 * Created by murphy on 2018/4/5.
 */
abstract class AbstractSummaryAdapter<T, out V : IAdapterView<T>>(mContext: Context, mList: ArrayList<T>) : ListAdapter<T, V>(mContext, mList) {
    protected val VIEW_TYPE_ITEM = 1 // Normal list item
    protected val VIEW_TYPE_FOOTER = 2  // Footer
    protected val VIEW_TYPE_HEADER = 3;
    /**
     * Default footer view is disabled, override in subclass and return true if want to enable it.
     */
    open fun isFooterEnabled(): Boolean {
        return false
    }

    open fun isHeaderEnabled(): Boolean {
        return false
    }

    open fun createHeaderView(): View? {
        return null
    }

    /**
     * @return Custom footer view, but override [.isFooterEnabled] and return true first.
     */
    open fun createFooterView(): View? {
        return null
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_HEADER) {
            object : RecyclerView.ViewHolder(createHeaderView()) {}
        } else if (viewType == VIEW_TYPE_FOOTER) {
            object : RecyclerView.ViewHolder(createFooterView()!!) {}
        } else super.onCreateViewHolder(parent, viewType)
    }

    override fun getItemViewType(position: Int): Int {
        return if (isHeaderEnabled() && position == 0) {
            VIEW_TYPE_HEADER
        } else if (isFooterEnabled() && position == itemCount - 1) {
            VIEW_TYPE_FOOTER
        } else VIEW_TYPE_ITEM
    }

    override fun getItemCount(): Int {
        var itemCount = super.getItemCount()
        if (isHeaderEnabled()) {
            itemCount += 1
        }
        if (isFooterEnabled()) {
            itemCount += 1
        }
        return itemCount
    }

    override fun getItem(position: Int): T? {
        return if (getItemViewType(position) == VIEW_TYPE_FOOTER) {
            null
        } else {
            var realPosition = position
            if (isHeaderEnabled()) {
                realPosition -= 1
            }
            super.getItem(realPosition)
        }
    }
}