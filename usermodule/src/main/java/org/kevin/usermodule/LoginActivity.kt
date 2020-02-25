package org.kevin.usermodule

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast
import org.kevin.module.baseAct.BaseMvpAct
import org.kevin.module.utils.PhoneUtil
import org.kevin.usermodule.data.model.JudeAccountData
import org.kevin.usermodule.presenter.LoginPresenter
import org.kevin.usermodule.presenter.view.LoginView

class LoginActivity : BaseMvpAct<LoginPresenter>(R.layout.activity_login), LoginView {
    companion object {
        private const val PERMISSION_PHONE_STATE = 0x00
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_PHONE_STATE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_PHONE_STATE),
                    PERMISSION_PHONE_STATE
                )
            }
        }
        presenter = LoginPresenter()
        presenter.controlView = this
        btnLogin.setOnClickListener {
            presenter.isRegister("CN", etNumber.text.toString().trim())
        }
    }

    override fun onLoginResult(result: Boolean) {
        toast("登录成功")
    }

    override fun isRegister(result: JudeAccountData) {
        if (result.getIs_exist() == 1) {
            toast("已经注册, 请登录")
            presenter.getCode(
                "CN",
                etNumber.text.toString().trim(),
                PhoneUtil.getInstance(this).imei
            )
        } else {
            toast("注册")
        }
    }

}
