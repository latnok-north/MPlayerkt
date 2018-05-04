package com.murphy.library.utils

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue

class DensityUtil {
    companion object {
        fun getScreenHeight(context: Context): Int {
            val displayMetrics = DisplayMetrics()
            (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
            return displayMetrics.heightPixels
        }

        fun getScreenWidth(context: Context): Int {
            val displayMetrics = DisplayMetrics()
            (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
            return displayMetrics.widthPixels
        }

        fun dip2px(context: Context, dpVale: Float): Int {
            val scale = context.resources.displayMetrics.density
            return (dpVale * scale + 0.5f).toInt()
        }

        fun getStatusBarHeight(context: Context): Int {
            val resources = context.resources
            val resourcesId = resources.getIdentifier("status_bar_height", "dimen", "android")
            return resources.getDimensionPixelSize(resourcesId)
        }

        /**
         * Converts sp to px
         *
         * @param context Context
         * @param sp  the value in sp
         * @return int
         */
        fun dip2sp(context: Context, sp: Float): Int {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.resources.displayMetrics).toInt()
        }

        fun px2dip(context: Context, pxValue: Float): Int {
            val scale = context.resources.displayMetrics.density
            return (pxValue / scale + 0.5f).toInt()
        }
    }
}