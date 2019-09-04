package org.kevin.kotlin.server

import rx.Observable

interface UserServer {

    fun register(account:String,verifyCode:String): Observable<Boolean>

}