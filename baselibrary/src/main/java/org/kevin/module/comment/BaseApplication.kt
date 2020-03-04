package org.kevin.module.comment

import android.app.Application
import org.kevin.module.injection.conponent.AppComponent
import org.kevin.module.injection.conponent.DaggerAppComponent
import org.kevin.module.injection.module.AppModule
import javax.inject.Inject

open class BaseApplication : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        initAppInjection()
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

}