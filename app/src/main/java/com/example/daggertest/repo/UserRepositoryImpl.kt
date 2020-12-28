package com.example.daggertest.repo

import com.example.daggertest.di.StorageModule.UserQualifier
import com.example.daggertest.di.UserScope
import com.example.daggertest.storage.Storage
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    @UserQualifier val storage: Storage
): UserRepository {

    override fun readValue(): String = storage.readValue()

    override fun writeValue(value: String) = storage.writeValue(value)

}