package org.kevin.kotlin.presenter

import org.kevin.kotlin.presenter.view.RegisterView
import org.kevin.kotlin.server.UserServer
import org.kevin.module.ext.excute
import org.kevin.module.presenter.BasePresenter
import org.kevin.module.rx.BaseSubscriber
import javax.inject.Inject

class RegisterPresenter @Inject constructor(): BasePresenter<RegisterView>() {
    @Inject
    lateinit var userServer: UserServer

    fun register(account: String, pwd: String) {
        userServer.register("", "").excute(object : BaseSubscriber<Boolean>() {
            override fun onNext(t: Boolean) {
                controlView.setCallBack("登录成功 ")
            }
        })

    }
}