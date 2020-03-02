package org.kevin.usermodule.injection.module

import dagger.Module
import dagger.Provides
import org.kevin.usermodule.server.UserServer
import org.kevin.usermodule.server.impl.UserServerImpl
import org.kevin.usermodule.server.impl.UserServerImpl2
import retrofit2.http.Field
import javax.inject.Named

@Module
class RegisterModule {

    @Named("server1")
    @Provides
    fun providesUserService(server: UserServerImpl): UserServer {
        return server
    }

    @Named("server2")
    @Provides
    fun providesUserService2(server: UserServerImpl2): UserServer {
        return server
    }
}