package com.example.daggertest.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.daggertest.App
import com.example.daggertest.R.layout
import com.example.daggertest.di.UserComponent

class MainActivity : AppCompatActivity() {

    var userComponent: UserComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        userComponent = (application as App).appComponent.userComponent().create()
        userComponent?.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layout.main_activity)
    }

    override fun onDestroy() {
        super.onDestroy()
        userComponent = null
    }
}