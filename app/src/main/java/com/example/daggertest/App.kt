package com.example.daggertest

import android.app.Application
import com.example.daggertest.di.AppComponent
import com.example.daggertest.di.DaggerAppComponent

class App: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.create()
    }
}