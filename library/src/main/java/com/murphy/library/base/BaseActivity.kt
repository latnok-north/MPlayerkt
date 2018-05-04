package com.murphy.library.base

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

/**
 * Created by murphy on 2018/3/31.
 */

abstract class BaseActivity : AppCompatActivity () {

    abstract fun onBaseCreate(savedInstanceState: Bundle?)
    abstract val layoutId: Int

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        onBaseCreate(savedInstanceState)
    }

    protected fun supportActionBar(toolbar: Toolbar): ActionBar? {
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
        }
        return actionBar
    }
}