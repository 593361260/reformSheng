package org.kevin.module.baseAct

import org.kevin.module.presenter.BasePresenter
import org.kevin.module.presenter.view.BaseView

open class BaseMvpAct<T : BasePresenter<*>> : BaseActivity(), BaseView {
    override fun showContent() {

    }

    override fun showOffline() {

    }

    override fun showLoading() {

    }

    override fun showEmpty() {

    }


    lateinit var presenter: T

}