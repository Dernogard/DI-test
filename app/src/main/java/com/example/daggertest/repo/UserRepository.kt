package com.example.daggertest.repo

interface UserRepository {

    /** запись строки в память */
    fun readValue(): String

    /** извлечение строки из памяти */
    fun writeValue(value: String)
}