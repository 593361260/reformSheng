package org.kevin.module.baseAct

import org.kevin.module.presenter.BasePresenter
import org.kevin.module.presenter.view.BaseView
import javax.inject.Inject

open class BaseMvpAct<T : BasePresenter<*>>(layout: Int = 0) : BaseActivity(layout), BaseView {
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