package org.kevin.usermodule.data.repostory

import org.kevin.module.data.net.RetrofitFactory
import org.kevin.module.data.protocol.BaseResp
import org.kevin.usermodule.data.api.UserApi
import org.kevin.usermodule.data.model.JudeAccountData
import org.kevin.usermodule.data.protocol.RegisterReq
import rx.Observable

class UserRepostory {
    fun getCode(areaCode: String, number: String, imei: String): Observable<BaseResp<Any>> {
        return RetrofitFactory.instances.create(UserApi::class.java).getCode(areaCode, number, imei)
    }
    fun isRegister(areaCode: String,number: String):Observable<BaseResp<JudeAccountData>>{
        return RetrofitFactory.instances.create(UserApi::class.java).isRegister(areaCode, number)
    }
}