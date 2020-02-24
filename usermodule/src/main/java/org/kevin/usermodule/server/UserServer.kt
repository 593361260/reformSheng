package org.kevin.usermodule.server

import org.kevin.module.data.protocol.BaseResp
import org.kevin.usermodule.data.model.JudeAccountData
import rx.Observable

interface UserServer {
    fun register(name: String, verifyCode: String, pwd: String): Observable<Boolean>
    fun getVerifyCode(name: String, verifyCode: String, pwd: String): Observable<BaseResp<Any>>
    fun isRegister(name: String, verifyCode: String):Observable<BaseResp<JudeAccountData>>

}