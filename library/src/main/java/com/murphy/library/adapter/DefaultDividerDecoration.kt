package com.murphy.library.adapter

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by murphy on 2018/4/5.
 */
class DefaultDividerDecoration : RecyclerView.ItemDecoration() {
    private val DIVIDER_HEIGHT = 1 // 1 pixel

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect?.bottom = DIVIDER_HEIGHT
    }
}