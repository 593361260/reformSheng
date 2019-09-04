package org.kevin.kotlin.presenter

import org.kevin.kotlin.presenter.view.RegisterView
import org.kevin.kotlin.server.impl.UserServerImpl
import org.kevin.module.ext.excute
import org.kevin.module.presenter.BasePresenter
import org.kevin.module.rx.BaseSubscriber

class RegisterPresenter : BasePresenter<RegisterView>() {

    fun register(account: String, pwd: String) {
        val userServerImpl = UserServerImpl()
        userServerImpl.register("", "").excute(object : BaseSubscriber<Boolean>() {
            override fun onNext(t: Boolean) {
                controlView.setCallBack("登录成功 ")
            }
        })
    }
}