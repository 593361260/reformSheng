package org.kevin.module.presenter

import com.trello.rxlifecycle.LifecycleProvider
import org.kevin.module.presenter.view.BaseView
import javax.inject.Inject

open class BasePresenter<T : BaseView> {
    lateinit var controlView: T

    @Inject
    lateinit var provider: LifecycleProvider<*>

}