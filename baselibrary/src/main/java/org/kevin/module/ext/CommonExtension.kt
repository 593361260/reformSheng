package org.kevin.module.ext

import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Observable 扩展方法
 */
fun <T> Observable<T>.execute(subscriber: Subscriber<T>) {
    this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber)
}