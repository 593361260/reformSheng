package org.kevin.usermodule.server.impl

import org.kevin.module.data.net.RetrofitFactory
import org.kevin.module.data.protocol.BaseResp
import org.kevin.usermodule.data.api.UserApi
import org.kevin.usermodule.data.model.JudeAccountData
import org.kevin.usermodule.data.repostory.UserRepostory
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
        return UserRepostory().getCode(areaCode, number, imei)
    }

    override fun isRegister(
        name: String,
        verifyCode: String
    ): Observable<BaseResp<JudeAccountData>> {
        return UserRepostory().isRegister(name,verifyCode)
    }

}