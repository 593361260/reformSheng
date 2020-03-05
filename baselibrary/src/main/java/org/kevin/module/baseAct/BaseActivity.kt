package org.kevin.module.baseAct

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.trello.rxlifecycle.components.support.RxAppCompatActivity
import org.kevin.module.comment.AppManager

open class BaseActivity(layout: Int = 0) : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instances.addStack(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instances.finishActivity(this)
    }
}