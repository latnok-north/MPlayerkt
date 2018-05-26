package com.murphy.library.data.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.murphy.library.data.model.ArtistArtModel
import android.arch.persistence.room.Room
import android.os.Handler
import com.murphy.library.data.room.dao.ArtistArtModelDao
import android.os.HandlerThread




@Database(entities = [(ArtistArtModel::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    private var mHandlerThread: HandlerThread = HandlerThread("dbThread")
    private var mThreadHandler: Handler
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

    init {
        mHandlerThread.start()
        mThreadHandler = Handler(mHandlerThread.looper)
    }

    fun postRunnable(runnable: Runnable) {
        mThreadHandler.post(runnable)
    }

    fun onDestroy() {
        mInstance = null
    }
    abstract fun getArtistArtModelDao() : ArtistArtModelDao
}