package com.example.daggertest.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.daggertest.databinding.FragmentCoroutineBinding
import io.reactivex.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ScreenCoroutine : Fragment() {

    private val TAG: String = javaClass.simpleName
    private lateinit var binding: FragmentCoroutineBinding
    private var counterJob: Job? = null
    private val single = Single.fromCallable { getMyText() }

    private fun getMyText(): String {
        Log.e(TAG, "Начинаем долгое получение данных")
        try {
            Thread.sleep(5000)
        } catch (e: Exception) {
        }
        return "Text в Single"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return FragmentCoroutineBinding.inflate(layoutInflater).apply {
            binding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonStart.setOnClickListener {
            if (counterJob == null || counterJob?.isActive == false) startJob()
            else stopJob().apply { binding.buttonStart.text = "Старт" }
        }
    }

    private fun startJob() {
        Log.e(TAG, "Начинаем работу")
        binding.counter.text = ""
        binding.buttonStart.text = "Стоп"

        counterJob = lifecycleScope.launch(Dispatchers.IO + SupervisorJob()) {
            var starNum = 1

            for (i in 0..100_000) {
                delay(500)
                if (i % 2 == 0) drawStar(starNum).apply { if (starNum >= 3) starNum = 0 else starNum++ }
                if (i == 3) {
                    launch {
                        val str = single.toSuspend()
                        Log.e(TAG, str)
                    }
                }
            }
        }
    }

    private fun stopJob() {
        Log.e(TAG, "Останавливаем работу")
        counterJob?.cancel()
    }

    private suspend fun drawStar(starNum: Int) {
        withContext(Main) {
            binding.counter.text = when (starNum) {
                1 -> "*"
                2 -> "* *"
                3 -> "* * *"
                else -> ""
            }
        }
    }
}
