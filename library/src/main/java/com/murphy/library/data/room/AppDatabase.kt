package com.murphy.library.data.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.murphy.library.data.model.ArtistArtModel
import android.arch.persistence.room.Room
import com.murphy.library.data.room.dao.ArtistArtModelDao
import android.os.HandlerThread




@Database(entities = [(ArtistArtModel::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        private var mInstance: AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase {
            if (mInstance == null) {
                synchronized(AppDatabase::class) {
                    if (mInstance == null) {
                        mInstance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java,
                                "mPlayer.db").addMigrations().build()
                    }
                }
            }

            return mInstance!!
        }
    }

    fun onDestroy() {
        mInstance = null
    }
    abstract fun getArtistArtModelDao() : ArtistArtModelDao
}