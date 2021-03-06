package com.rtukpe.fixtures.utils.rx;

import io.reactivex.Observable;

interface EventBus {

    fun post(event: Any)

    fun <T> observe(eventClass: Class<T>): Observable<T>

    fun cleanup()
}
