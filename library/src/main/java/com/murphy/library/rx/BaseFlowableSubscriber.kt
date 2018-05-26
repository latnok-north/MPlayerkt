package com.murphy.library.rx

import io.reactivex.FlowableSubscriber
import org.reactivestreams.Subscription

abstract class BaseFlowableSubscriber<T> : FlowableSubscriber<T> {

    protected abstract fun onSuccess(t: T)
    protected abstract fun onFailure(e: Throwable)

    override fun onComplete() {
    }

    override fun onSubscribe(s: Subscription) {
    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(t: Throwable) {
        onFailure(t)
    }
}