package com.murphy.library.rx

import android.accounts.NetworkErrorException
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.net.ConnectException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException


/**
 * Created by murphy on 2018/4/7.
 */
abstract class BaseObserver<T> : Observer<T> {

    @Throws(Exception::class)
    protected abstract fun onSuccess(t: T)


    @Throws(Exception::class)
    private fun onFailure(e: Throwable, isNetWorkError: Boolean) {
        if (isNetWorkError) {
            onFailure(e)
        } else{
            onFailure(e)
        }
    }

    protected abstract fun onFailure(e: Throwable)


    override fun onSubscribe(d: Disposable) {
        onRequestStart()
    }

    override fun onNext(t: T) {
        onRequestEnd()
        try {
            onSuccess(t)
        } catch (e: Exception) {
            onFailure(e, false)
        }
    }

    override fun onError(e: Throwable) {
        onRequestEnd()
        try {
            if (e is ConnectException
                    || e is TimeoutException
                    || e is NetworkErrorException
                    || e is UnknownHostException) {
                onFailure(e, true)
            } else {
                onFailure(e, false)
            }
        } catch (e1: Exception) {
            e1.printStackTrace()
        }

    }

    override fun onComplete() {

    }


    open fun onRequestStart() {}

    open fun onRequestEnd() {}
}