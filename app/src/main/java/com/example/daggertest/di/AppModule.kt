package com.example.daggertest.di

import com.example.daggertest.repo.MainRepository
import com.example.daggertest.repo.MainRepositoryImpl
import com.example.daggertest.repo.UserRepository
import com.example.daggertest.repo.UserRepositoryImpl
import com.example.daggertest.storage.MainStorage
import com.example.daggertest.storage.Storage
import com.example.daggertest.storage.UserStorage
import com.example.daggertest.ui.main.MainActivity
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single<MainRepository> { MainRepositoryImpl(get(qualifier = named("MainStorage"))) }

    factory<Storage>(qualifier = named("MainStorage")) { MainStorage() }
}

val userModule = module {
    scope(named<MainActivity>()){
        scoped {
            UserRepositoryImpl(get(qualifier = named("UserStorage"))) } bind UserRepository::class
        }

    factory<Storage>(qualifier = named("UserStorage")) { UserStorage() }
}


