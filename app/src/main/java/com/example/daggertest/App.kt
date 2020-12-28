package com.example.daggertest

import android.app.Application
import com.example.daggertest.di.appModule
import com.example.daggertest.di.userModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModule, userModule)
        }
    }
}