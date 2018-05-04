package com.murphy.library.utils

import android.util.Log

/**
 * Created by murphy on 2018/3/31.
 */

class LogUtils {

    companion object {
        fun i(tag: String, msg: String) {
            Log.i(tag, msg)
        }

        fun e(tag: String, msg: String) {
            Log.e(tag, msg)
        }

        fun d(tag: String, msg: String) {
            Log.d(tag, msg)
        }

        fun w(tag: String, msg: String) {
            Log.w(tag, msg)
        }

        fun v(tag: String, msg: String) {
            Log.v(tag, msg)
        }
    }


}