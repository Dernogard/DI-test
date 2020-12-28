package com.example.daggertest.di

import com.example.daggertest.ui.main.MainFragment
import dagger.Subcomponent
import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME

@ActivityScope
@Subcomponent
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(fragment: MainFragment)
}

/** область видимости ЖЦ активити  */
@Scope
@Retention(RUNTIME)
annotation class ActivityScope
