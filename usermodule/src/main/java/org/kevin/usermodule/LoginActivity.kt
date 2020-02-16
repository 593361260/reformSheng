package org.kevin.usermodule

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import org.kevin.module.baseAct.BaseMvpAct
import org.kevin.usermodule.presenter.LoginPresenter
import org.kevin.usermodule.presenter.view.LoginView

class LoginActivity : BaseMvpAct<LoginPresenter>(R.layout.activity_main), LoginView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = LoginPresenter()
        presenter.controlView = this
        btnLogin.setOnClickListener {
            presenter.login("", "")
        }
    }

    override fun onLoginResult(result: Boolean) {
        toast("登录成功")
    }

}
