package com.murphy.library.helper

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.murphy.library.Constants
import com.murphy.library.net.RetrofitClient
import com.murphy.library.utils.SortOrderUtils

/**
 * Created by murphy on 2018/4/7.
 */
class PreferenceHelper private constructor(context: Context){

    init {
        mPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    }

    companion object {

        @Volatile
        private var mPreferences: SharedPreferences? = null

        private var mInstance: PreferenceHelper? = null
        fun getInstance(context: Context): PreferenceHelper {
            if (mInstance == null) {
                synchronized(PreferenceHelper::class) {
                    if (mInstance == null) {
                        mInstance = PreferenceHelper(context.applicationContext)
                    }
                }
            }
            return mInstance!!
        }



        private val PREFS_NAME = "config.xml"

        private val KEY_FOLDERS_FIRST_QUERY = "firstQueryFolders"
        private val ARTIST_SORT_ORDER = "artist_sort_order"
        private val ARTIST_SONG_SORT_ORDER = "artist_song_sort_order"
        private val ARTIST_ART_URL = "artist_art_url_"
        private val ALBUM_SORT_ORDER = "album_sort_order"
        private val ALBUM_SONG_SORT_ORDER = "album_song_sort_order"
        private val SONG_SORT_ORDER = "song_sort_order"
        private val TOGGLE_ARTIST_GRID = "toggle_artist_grid"
        private val TOGGLE_ALBUM_GRID = "toggle_album_grid"
        private val TOGGLE_PLAYLIST_VIEW = "toggle_playlist_view"
        private val START_PAGE_INDEX = "start_page_index"
    }


    fun getAlbumSortOrder(): String {
        return mPreferences!!.getString(ALBUM_SORT_ORDER, SortOrderUtils.AlbumSortOrder.ALBUM_A_Z)
    }

    fun getArtistSortOrder(): String {
        return mPreferences!!.getString(ARTIST_SORT_ORDER, SortOrderUtils.ArtistSortOrder.ARTIST_A_Z)
    }

    fun getSongSortOrder(): String? {
        return mPreferences!!.getString(SONG_SORT_ORDER, SortOrderUtils.SongSortOrder.SONG_A_Z)
    }

    fun isFirstQueryFolders(): Boolean {
        return mPreferences!!.getBoolean(KEY_FOLDERS_FIRST_QUERY, true)
    }


}