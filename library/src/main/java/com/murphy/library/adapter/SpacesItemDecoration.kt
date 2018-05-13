package com.murphy.library.adapter

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class SpacesItemDecoration(var space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        val position = parent?.getChildAdapterPosition(view) ?: return
        if (position % 2 == 0) {
            outRect?.left = 0
            outRect?.top = space
            outRect?.right = space / 2
        } else {
            outRect?.left = space / 2
            outRect?.top = space
            outRect?.right = 0
        }
    }
}