package com.murphy.library.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private val mSubscriptions = CompositeDisposable()


    fun addSubcirpt(d: Disposable) {
        mSubscriptions.add(d)
    }

    fun showDialog(txt: String) {

    }

    fun showDialog() {
        showDialog("")
    }

    override fun onCleared() {
        super.onCleared()
        mSubscriptions.clear()
    }
}