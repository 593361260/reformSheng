package org.kevin.module.injection.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import org.kevin.module.injection.ActivityScope

@Module
class ActivityModule(private val activity: Activity) {

    @ActivityScope
    @Provides
    fun providesActivity(): Activity {
        return activity
    }
}