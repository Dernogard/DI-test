package com.example.daggertest.di

import com.example.daggertest.repo.MainRepository
import com.example.daggertest.repo.MainRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class MainModule {

    @Binds
    abstract fun provideMainRepo(repo: MainRepositoryImpl): MainRepository

}