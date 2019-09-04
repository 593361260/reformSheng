package org.kevin.module.presenter

import org.kevin.module.presenter.view.BaseView

open class BasePresenter<T : BaseView> {
    lateinit var controlView: T
}