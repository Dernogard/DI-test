package com.example.daggertest.di

import com.example.daggertest.repo.UserRepository
import com.example.daggertest.repo.UserRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class UserModule {

    @UserScope
    @Binds
    abstract fun provideUserRepo(repo: UserRepositoryImpl): UserRepository

}
