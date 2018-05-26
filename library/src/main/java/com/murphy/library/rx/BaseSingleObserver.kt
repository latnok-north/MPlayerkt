package com.murphy.library.rx

import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

abstract class BaseSingleObserver<T> : SingleObserver<T> {

    override fun onSubscribe(d: Disposable) {

    }
}