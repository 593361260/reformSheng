package org.kevin.usermodule.server.impl

import org.kevin.module.data.protocol.BaseResp
import org.kevin.usermodule.data.model.JudeAccountData
import org.kevin.usermodule.data.repository.UserRepository
import org.kevin.usermodule.server.UserServer
import rx.Observable

class UserServerImpl : UserServer {
    override fun register(name: String, verifyCode: String, pwd: String): Observable<Boolean> {
        return Observable.just(true)
    }

    override fun getVerifyCode(
        areaCode: String,
        number: String,
        imei: String
    ): Observable<BaseResp<Any>> {
        return UserRepository().getCode(areaCode, number, imei)
    }

    override fun isRegister(
        name: String,
        verifyCode: String
    ): Observable<BaseResp<JudeAccountData>> {
        return UserRepository().isRegister(name,verifyCode)
    }

}