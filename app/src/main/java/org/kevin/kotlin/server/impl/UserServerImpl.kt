package org.kevin.kotlin.server.impl

import org.kevin.kotlin.server.UserServer
import rx.Observable
import javax.inject.Inject

class UserServerImpl @Inject constructor():UserServer{
    override fun register(account: String, verifyCode: String): Observable<Boolean> {
         return Observable.just(true)
    }
}