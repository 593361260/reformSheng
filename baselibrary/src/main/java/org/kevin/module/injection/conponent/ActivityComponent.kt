package org.kevin.module.injection.conponent

import dagger.Component
import org.kevin.module.injection.ActivityScope
import org.kevin.module.injection.module.ActivityModule

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

}