package com.murphy.library.adapter

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.murphy.library.R
import com.murphy.library.utils.ATEUtil
import com.murphy.library.utils.DensityUtil

class DividerItemDecoration() : RecyclerView.ItemDecoration() {

    companion object {
        val HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL
        val VERTICAL_LIST = LinearLayoutManager.VERTICAL
    }

    private val ATTRS = intArrayOf(android.R.attr.listDivider)
    private var mDivider: Drawable? = null

    private var mOrientation: Int = 0
    private var withHeader: Boolean = false


    constructor(context: Context, orientation: Int, withHeader: Boolean) : this() {
        val a = context.obtainStyledAttributes(ATTRS)
        mDivider = if (ATEUtil.getATEKey(context).equals("light_theme")) {
            ContextCompat.getDrawable(context, R.drawable.item_divider_black)
        } else {
            ContextCompat.getDrawable(context, R.drawable.item_divider_white)
        }
        this.withHeader = withHeader
        a.recycle()
        setOrientation(orientation)
    }

    constructor(context: Context, orientation: Int, resId: Int) : this() {
        mDivider = ContextCompat.getDrawable(context, resId)
        setOrientation(orientation)
    }

    private fun setOrientation(orientation: Int) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw IllegalArgumentException("invalid orientation")
        }
        mOrientation = orientation
    }

    override fun onDraw(c: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {

        if (mOrientation == VERTICAL_LIST) {
            drawVertical(c!!, parent!!)
        } else {
            drawHorizontal(c!!, parent!!)
        }
    }

    private fun drawVertical(c: Canvas, parent: RecyclerView) {
        var left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for (i in 0 until childCount - 1) {
            val child = parent.getChildAt(i)
            val params = child
                    .layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + (mDivider?.intrinsicHeight ?: 0)
            if (i != 0 || !withHeader) {
                left = parent.paddingLeft + DensityUtil.dip2px(parent.context, 72F)
            }
            mDivider?.setBounds(left, top, right, bottom)
            mDivider?.draw(c)
        }
    }

    private fun drawHorizontal(c: Canvas, parent: RecyclerView) {
        val top = parent.paddingTop
        val bottom = parent.height - parent.paddingBottom

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val params = child
                    .layoutParams as RecyclerView.LayoutParams
            val left = child.right + params.rightMargin
            val right = left + (mDivider?.intrinsicHeight ?: 0)
            mDivider?.setBounds(left, top, right, bottom)
            mDivider?.draw(c)
        }
    }

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        if (mOrientation == VERTICAL_LIST) {
            outRect?.set(0, 0, 0, (mDivider?.intrinsicWidth ?:0))
        } else {
            outRect?.set(0, 0, (mDivider?.intrinsicWidth ?:0), 0)
        }
    }
}