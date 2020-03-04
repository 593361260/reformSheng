package org.kevin.module.baseAct

import android.os.Bundle
import org.kevin.module.comment.BaseApplication
import org.kevin.module.injection.conponent.ActivityComponent
import org.kevin.module.injection.conponent.DaggerActivityComponent
import org.kevin.module.injection.module.ActivityModule
import org.kevin.module.injection.module.LifecycleProviderModule
import org.kevin.module.presenter.BasePresenter
import org.kevin.module.presenter.view.BaseView
import javax.inject.Inject

open class BaseMvpAct<T : BasePresenter<*>>(layout: Int = 0) : BaseActivity(layout), BaseView {
    lateinit var activityComponent: ActivityComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
    }

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder()
            .appComponent((application as BaseApplication).appComponent)
            .activityModule(ActivityModule(this))
            .lifecycleProviderModule(LifecycleProviderModule(this)).build()
    }

    override fun showContent() {

    }

    override fun showOffline() {

    }

    override fun showLoading() {

    }

    override fun showEmpty() {

    }

    @Inject
    lateinit var presenter: T

}