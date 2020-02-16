package org.kevin.usermodule.presenter.view

import org.kevin.module.presenter.view.BaseView

interface LoginView : BaseView{
    fun onLoginResult(result:Boolean)
}