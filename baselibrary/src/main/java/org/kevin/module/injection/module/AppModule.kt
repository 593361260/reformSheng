package org.kevin.module.injection.module

import android.content.Context
import dagger.Module
import dagger.Provides
import org.kevin.module.comment.BaseApplication
import javax.inject.Singleton

@Module//全局唯一的提供
class AppModule(private val context: BaseApplication) {
    @Singleton
    @Provides
    fun providesContext(): Context {
        return context
    }
}