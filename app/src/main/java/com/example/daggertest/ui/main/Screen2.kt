package com.example.daggertest.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.daggertest.R
import com.example.daggertest.databinding.FragmentScreen2Binding
import com.example.daggertest.repo.MainRepository
import com.example.daggertest.repo.UserRepository
import org.koin.android.ext.android.inject

class Screen2: Fragment() {

    private val mainRepository: MainRepository by inject()
    private lateinit var userRepository: UserRepository

    private var count = 0

    private lateinit var binding: FragmentScreen2Binding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        userRepository = (activity as MainActivity).userRepository
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return FragmentScreen2Binding.inflate(layoutInflater).apply {
            binding = this
        }.root
    }

    override fun onResume() {
        super.onResume()
        binding.userName.text = getNameFromMainRepository()
        count = getUserNumberFromUserRepository().toIntOrNull() ?: 0
        binding.userNumOne.text = count.toString()
    }

    private fun getUserNumberFromUserRepository(): String {
        return userRepository.readValue()
    }

    private fun getNameFromMainRepository(): String {
        return mainRepository.readValue()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toMainScreen.setOnClickListener { findNavController().navigate(R.id.mainFragment) }
    }
}