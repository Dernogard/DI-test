package com.example.daggertest.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.daggertest.App
import com.example.daggertest.R
import com.example.daggertest.databinding.MainFragmentBinding
import com.example.daggertest.repo.MainRepository
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject lateinit var mainRepository: MainRepository

    private lateinit var binding: MainFragmentBinding

    override fun onAttach(context: Context) {
        (activity?.application as App).appComponent.mainComponent().create().inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return MainFragmentBinding.inflate(layoutInflater).apply {
            binding = this
        }.root
    }

    override fun onResume() {
        super.onResume()
        binding.userName.text = getNameFromMainRepository()
    }

    private fun getNameFromMainRepository(): String {
        return mainRepository.readValue()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toScreen1.setOnClickListener { findNavController().navigate(R.id.action_mainFragment_to_screen12) }
        binding.buttonSaveName.setOnClickListener { saveNameToMainRepository() }
    }

    private fun saveNameToMainRepository() {
        val name = binding.fieldName.text
        binding.userName.text = name
        mainRepository.writeValue(name.toString())
    }
}