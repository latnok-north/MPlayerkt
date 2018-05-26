package com.murphy.library.base

import android.app.Application
//import io.objectbox.BoxStore

class MPApplication : Application() {

    companion object {
        lateinit var mInstance: MPApplication

        fun getInstance(): MPApplication {
            return mInstance
        }
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
//        mBoxStore = MyObjectBox.builder().androidContext(this).build()
    }
}