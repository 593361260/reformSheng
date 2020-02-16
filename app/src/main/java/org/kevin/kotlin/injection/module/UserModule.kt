package org.kevin.kotlin.injection.module

import dagger.Module
import dagger.Provides
import org.kevin.kotlin.server.UserServer
import org.kevin.kotlin.server.impl.UserServerImpl

@Module
class UserModule {
    @Provides
    fun providusUserServer(server: UserServerImpl): UserServer {
        return server
    }

}