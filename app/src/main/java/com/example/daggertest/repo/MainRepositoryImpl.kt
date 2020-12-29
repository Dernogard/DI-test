package com.example.daggertest.repo

import com.example.daggertest.storage.Storage
import javax.inject.Inject

class MainRepositoryImpl constructor(
    private val storage: Storage
): MainRepository {

    override fun readValue(): String = storage.readValue()

    override fun writeValue(value: String) = storage.writeValue(value)
}