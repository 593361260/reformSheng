package org.kevin.usermodule.injection.component

import dagger.Component
import org.kevin.module.injection.PerComponentScope
import org.kevin.module.injection.conponent.ActivityComponent
import org.kevin.usermodule.LoginActivity
import org.kevin.usermodule.injection.module.RegisterModule
@PerComponentScope
@Component(dependencies = [ActivityComponent::class], modules = [RegisterModule::class])
interface UserComponent {
    fun inject(activity: LoginActivity)
}