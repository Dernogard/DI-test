package com.example.daggertest.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppSubcomponent::class, MainModule::class, StorageModule::class])
interface AppComponent {

    fun userComponent(): UserComponent.Factory
    fun mainComponent(): MainComponent.Factory

}