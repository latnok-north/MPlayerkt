package com.murphy.library.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.preference.PreferenceManager
import android.util.TypedValue

class ATEUtil {
    companion object {
        fun getATEKey(context: Context): String {
            return if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean("dark_theme", false))
                "dark_theme"
            else
                "light_theme"
        }
    }
}