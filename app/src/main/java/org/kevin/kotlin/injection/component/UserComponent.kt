package org.kevin.kotlin.injection.component

import dagger.Component
import org.kevin.kotlin.LoginAct
import org.kevin.kotlin.injection.module.UserModule


@Component(modules = [UserModule::class])
interface UserComponent {

    fun inject(activity:LoginAct)
}