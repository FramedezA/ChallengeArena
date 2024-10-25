package com.example.login.presentation.di

import com.example.core.AppDeps
import com.example.login.presentation.LoginFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        LoginModule::class
    ],
    dependencies = [AppDeps::class]
)
interface LoginComponent {

    fun inject(loginFragment: LoginFragment)

    @Component.Builder
    interface Builder {
        fun appDeps(appDeps: AppDeps): Builder
        fun build(): LoginComponent
    }

}