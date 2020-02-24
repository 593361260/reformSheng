package org.kevin.usermodule.data.api

import org.kevin.module.data.protocol.BaseResp
import org.kevin.usermodule.data.model.JudeAccountData
import org.kevin.usermodule.data.protocol.RegisterReq
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface UserApi {
    fun register(@Body req: RegisterReq): Observable<BaseResp<String>>

    @GET("users/code/{areaCode}/{number}/{imei}")
    fun getCode(@Path("areaCode") areaCode: String, @Path("number") number: String, @Path("imei") imei: String): Observable<BaseResp<Any>>

    @GET("users/{areaCode}/{number}")
    fun isRegister(@Path("areaCode") areaCode: String, @Path("number") number: String): Observable<BaseResp<JudeAccountData>>

}