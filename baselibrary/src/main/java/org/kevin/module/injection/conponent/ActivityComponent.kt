package org.kevin.module.injection.conponent

import android.app.Activity
import android.content.Context
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component
import org.kevin.module.injection.ActivityScope
import org.kevin.module.injection.module.ActivityModule
import org.kevin.module.injection.module.LifecycleProviderModule

@ActivityScope
@Component(
    dependencies = [AppComponent::class],
    modules = [ActivityModule::class, LifecycleProviderModule::class]
)
interface ActivityComponent {
    fun context(): Context
    fun activity(): Activity
    fun lifecycleProvider(): LifecycleProvider<*>
}