package com.example.daggertest.di

import com.example.daggertest.ui.main.MainActivity
import com.example.daggertest.ui.main.Screen1
import com.example.daggertest.ui.main.Screen2
import dagger.Subcomponent
import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME

@UserScope
@Subcomponent(modules = [UserModule::class])
interface UserComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): UserComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: Screen1)
    fun inject(fragment: Screen2)
}

/** область видимости первый экран пользователя  */
@Scope
@Retention(RUNTIME)
annotation class UserScope
