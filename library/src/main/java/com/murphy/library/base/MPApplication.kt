package com.murphy.library.base

import android.app.Application
//import io.objectbox.BoxStore

class MPApplication : Application() {


//    lateinit var mBoxStore: BoxStore

    companion object {
        var mInstance: MPApplication? = null

        fun getInstance(): MPApplication? {
            return mInstance
        }
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
//        mBoxStore = MyObjectBox.builder().androidContext(this).build()
    }
}