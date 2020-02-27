package org.kevin.usermodule.server.impl

import org.kevin.module.data.protocol.BaseResp
import org.kevin.usermodule.data.model.JudeAccountData
import org.kevin.usermodule.data.repository.UserRepository
import org.kevin.usermodule.server.UserServer
import rx.Observable
import javax.inject.Inject

class UserServerImpl2 @Inject constructor() : UserServer {
    @Inject
    lateinit var userRepository: UserRepository

    override fun register(name: String, verifyCode: String, pwd: String): Observable<Boolean> {
        return Observable.just(true)
    }

    override fun getVerifyCode(
        areaCode: String,
        number: String,
        imei: String
    ): Observable<BaseResp<Any>> {
        return userRepository.getCode(areaCode, number, imei)
    }

    override fun isRegister(
        name: String,
        verifyCode: String
    ): Observable<BaseResp<JudeAccountData>> {
        return userRepository.isRegister(name, verifyCode)
    }

}