package com.murphy.library.utils

import android.text.TextUtils
import android.widget.ImageView
import com.murphy.library.glide.GlideApp


class ImageUtils {

    companion object {
        fun display(url: String, imageView: ImageView) {
            if (TextUtils.isEmpty(url)) {
                return
            }
            GlideApp.with(imageView.context)
                    .load(url)
                    .fitCenter()
                    .into(imageView)
        }

        fun display(url: String, imageView: ImageView, default: Int) {
//            if (TextUtils.isEmpty(url)) {
//                return
//            }

            val drawable = ATEUtil.getDefaultSingerDrawable(imageView.context, default)
            imageView.setImageDrawable(drawable)

            GlideApp.with(imageView.context)
                    .load(url)
                    .placeholder(drawable)
                    .dontAnimate()
                    .fitCenter()
                    .into(imageView)
        }
    }
}