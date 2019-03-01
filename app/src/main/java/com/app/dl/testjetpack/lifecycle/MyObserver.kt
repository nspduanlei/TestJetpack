package com.app.dl.testjetpack.lifecycle

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent


class MyObserver(var lifecycle: Lifecycle, var callback: Callback) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public fun connectOnCreate() {
        p("connectOnCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public fun connectOnResume() {
        p("connectOnResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public fun disConnectOnDestroy() {
        p("disConnectOnDestroy")
    }

    fun p(string: String) {
        callback.update(string)
    }
}