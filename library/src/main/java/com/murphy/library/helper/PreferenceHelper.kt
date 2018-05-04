package com.murphy.library.helper

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by murphy on 2018/4/7.
 */
class PreferenceHelper {

    companion object {
        private val PREFS_NAME = "config.xml"

        private val KEY_FOLDERS_FIRST_QUERY = "firstQueryFolders"


        fun isFirstQueryFolders(context: Context): Boolean {
            return preferences(context).getBoolean(KEY_FOLDERS_FIRST_QUERY, true)
        }

        private fun preferences(context: Context): SharedPreferences {
            return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        }
    }
}