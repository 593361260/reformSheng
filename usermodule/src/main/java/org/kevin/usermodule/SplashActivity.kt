package org.kevin.usermodule

import android.os.Bundle
import android.os.Handler
import org.jetbrains.anko.startActivity
import org.kevin.module.baseAct.BaseActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({
            startActivity<LoginActivity>()
            finish()
        }, 1000)
    }
}