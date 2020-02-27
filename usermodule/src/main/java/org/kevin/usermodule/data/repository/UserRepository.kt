package org.kevin.usermodule.data.repository

import org.kevin.module.data.net.RetrofitFactory
import org.kevin.module.data.protocol.BaseResp
import org.kevin.usermodule.data.api.UserApi
import org.kevin.usermodule.data.model.JudeAccountData
import rx.Observable
import javax.inject.Inject

class UserRepository @Inject constructor(){
    fun getCode(areaCode: String, number: String, imei: String): Observable<BaseResp<Any>> {
        return RetrofitFactory.instances.create(UserApi::class.java).getCode(areaCode, number, imei)
    }
    fun isRegister(areaCode: String,number: String):Observable<BaseResp<JudeAccountData>>{
        return RetrofitFactory.instances.create(UserApi::class.java).isRegister(areaCode, number)
    }
}