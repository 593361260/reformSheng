package org.kevin.usermodule.presenter.view

import org.kevin.module.presenter.view.BaseView
import org.kevin.usermodule.data.model.JudeAccountData

interface LoginView : BaseView {
    fun onLoginResult(result: Boolean)
    fun isRegister(result: JudeAccountData)
}