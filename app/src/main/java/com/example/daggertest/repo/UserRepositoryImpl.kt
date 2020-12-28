package com.example.daggertest.repo

import com.example.daggertest.storage.Storage
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    val storage: Storage
): UserRepository {

    override fun readValue(): String = storage.readValue()

    override fun writeValue(value: String) = storage.writeValue(value)

}