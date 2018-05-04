package com.murphy.library.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel: ViewModel() {

    private val mSubscriptions = CompositeDisposable()



    override fun onCleared() {
        super.onCleared()
        mSubscriptions.clear()
    }
}