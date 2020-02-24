package org.kevin.usermodule.presenter

import org.kevin.module.presenter.BasePresenter
import org.kevin.module.rx.BaseSubscriber
import org.kevin.usermodule.presenter.view.LoginView
import org.kevin.usermodule.server.impl.UserServerImpl
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class LoginPresenter : BasePresenter<LoginView>() {

    fun login(name: String, verifyCode: String, pwd: String) {
        UserServerImpl().register(name, verifyCode, pwd).observeOn(AndroidSchedulers.mainThread())
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
        UserServerImpl().getVerifyCode(areaCode, number, imei)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe(object : BaseSubscriber<Any>() {
                override fun onNext(t: Any) {
                    controlView.onLoginResult(true)
                }
            })
    }
}