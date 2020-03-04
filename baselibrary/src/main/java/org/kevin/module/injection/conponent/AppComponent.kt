package org.kevin.module.injection.conponent

import android.content.Context
import dagger.Component
import dagger.Module
import org.kevin.module.injection.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun context():Context
}