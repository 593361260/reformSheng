package org.kevin.kotlin

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import org.kevin.kotlin.injection.component.DaggerUserComponent
import org.kevin.kotlin.injection.module.UserModule
import org.kevin.kotlin.presenter.RegisterPresenter
import org.kevin.kotlin.presenter.view.RegisterView
import org.kevin.module.baseAct.BaseMvpAct
import androidx.core.app.ActivityCompat


class LoginAct : BaseMvpAct<RegisterPresenter>(), RegisterView {

    override fun setCallBack(result: Any) {
        if (result is String)
            toast(result.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    0
                )
            }
        }
        initComponent()
        btnLogin.setOnClickListener {
            presenter.register("", "")
        }
    }

    private fun initComponent() {
        DaggerUserComponent.builder().userModule(UserModule()).build().inject(this)
        presenter.controlView = this
    }

}
