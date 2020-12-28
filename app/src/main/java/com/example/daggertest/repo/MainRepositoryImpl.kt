package com.example.daggertest.repo

import com.example.daggertest.di.StorageModule.MainQualifier
import com.example.daggertest.storage.Storage
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepositoryImpl @Inject constructor(
    @MainQualifier private val storage: Storage
): MainRepository {

    override fun readValue(): String = storage.readValue()

    override fun writeValue(value: String) = storage.writeValue(value)
}