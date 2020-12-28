package com.example.daggertest.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.daggertest.R
import com.example.daggertest.databinding.FragmentScreen1Binding
import com.example.daggertest.repo.MainRepository
import com.example.daggertest.repo.UserRepository
import javax.inject.Inject

class Screen1: Fragment() {

    @Inject lateinit var mainRepository: MainRepository
    @Inject lateinit var userRepository: UserRepository

    private var count = 0

    private lateinit var binding: FragmentScreen1Binding

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity() as MainActivity).userComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return FragmentScreen1Binding.inflate(layoutInflater).apply {
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
        binding.toScreen2.setOnClickListener { findNavController().navigate(R.id.action_screen12_to_screen22) }
        binding.buttonPlus.setOnClickListener { increaseCount() }
    }

    private fun increaseCount() {
        count++
        binding.userNumOne.text = count.toString()
        userRepository.writeValue(count.toString())
    }
}