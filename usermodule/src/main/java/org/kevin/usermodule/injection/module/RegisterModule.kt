package org.kevin.usermodule.injection.module

import dagger.Module
import dagger.Provides
import org.kevin.usermodule.server.UserServer
import org.kevin.usermodule.server.impl.UserServerImpl

@Module
class RegisterModule {
    @Provides
    fun providesUserService(server: UserServerImpl): UserServer {
        return server
    }
}