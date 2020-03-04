package org.kevin.module.injection.module

import com.trello.rxlifecycle.LifecycleProvider
import dagger.Module
import dagger.Provides
import org.kevin.module.injection.ActivityScope

@Module
class LifecycleProviderModule(private val lifecycle: LifecycleProvider<*>) {

    @ActivityScope
    @Provides
    fun providesLifecycleProvider(): LifecycleProvider<*> {
        return lifecycle
    }
}