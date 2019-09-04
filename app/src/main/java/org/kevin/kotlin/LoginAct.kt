package org.kevin.kotlin

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import org.kevin.kotlin.presenter.RegisterPresenter
import org.kevin.kotlin.presenter.view.RegisterView
import org.kevin.module.baseAct.BaseMvpAct

class LoginAct : BaseMvpAct<RegisterPresenter>(), RegisterView {
    override fun setCallBack(result: Any) {
        if (result is String)
            toast(result.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = RegisterPresenter()
        presenter.controlView = this
        btnLogin.setOnClickListener {
            presenter.register("", "")
        }

    }
}
