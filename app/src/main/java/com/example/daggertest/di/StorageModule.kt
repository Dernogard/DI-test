package com.example.daggertest.di

import com.example.daggertest.storage.MainStorage
import com.example.daggertest.storage.Storage
import com.example.daggertest.storage.UserStorage
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier

@Module
class StorageModule {

    @Qualifier annotation class UserQualifier

    @Qualifier annotation class MainQualifier

    @Provides
    @UserQualifier
    fun provideUserStorage(): Storage = UserStorage()

    @Provides
    @MainQualifier
    fun provideMainStorage(): Storage = MainStorage()

}