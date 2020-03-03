package org.kevin.usermodule.presenter

import com.trello.rxlifecycle.LifecycleProvider
import org.kevin.module.data.protocol.BaseResp
import org.kevin.module.ext.execute
import org.kevin.module.presenter.BasePresenter
import org.kevin.module.rx.BaseSubscriber
import org.kevin.usermodule.data.model.JudeAccountData
import org.kevin.usermodule.presenter.view.LoginView
import org.kevin.usermodule.server.impl.UserServerImpl
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {
    @Inject
    lateinit var userService: UserServerImpl
    lateinit var provider: LifecycleProvider<*>
    fun login(name: String, verifyCode: String, pwd: String) {
        userService.register(name, verifyCode, pwd).observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe(object : Observer<Boolean> {
                override fun onError(e: Throwable?) {

                }

                override fun onNext(t: Boolean?) {
                    controlView.onLoginResult(true)
                }

                override fun onCompleted() {
                }
            })
    }

    fun getCode(
        areaCode: String,
        number: String,
        imei: String
    ) {
        userService.getVerifyCode(areaCode, number, imei)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe(object : BaseSubscriber<Any>() {
                override fun onNext(t: Any) {
                    controlView.onLoginResult(true)
                }
            })
    }

    fun isRegister(areaCode: String, number: String) {
        userService.isRegister(areaCode, number)
            .execute(object : BaseSubscriber<BaseResp<JudeAccountData>>() {
                override fun onNext(t: BaseResp<JudeAccountData>) {
                    controlView.isRegister(t.data)
                }
            }, provider)
    }
}