package com.example.daggertest.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.daggertest.R.layout
import com.example.daggertest.repo.UserRepository
import org.koin.android.ext.android.getKoin
import org.koin.android.scope.lifecycleScope
import org.koin.core.scope.Scope

class MainActivity : AppCompatActivity() {

    val userRepository: UserRepository by lifecycleScope.inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.main_activity)
    }
}