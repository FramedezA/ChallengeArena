package com.example.network.di

import com.example.core.AppDeps
import com.example.network.AuthInterceptor
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        NetworkModule::class
    ],
    dependencies = [AppDeps::class]
)
interface NetworkComponent {

    fun inject(authInterceptor: AuthInterceptor)



    @Component.Builder
    interface Builder {
        fun appDeps(appDeps: AppDeps): Builder
        fun build(): NetworkComponent
    }

}