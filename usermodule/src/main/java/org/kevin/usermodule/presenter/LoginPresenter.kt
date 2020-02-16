package org.kevin.usermodule.presenter

import org.kevin.module.presenter.BasePresenter
import org.kevin.usermodule.presenter.view.LoginView

class LoginPresenter : BasePresenter<LoginView>() {

    fun login(name: String, pwd: String) {
        controlView.onLoginResult(true)

    }

}