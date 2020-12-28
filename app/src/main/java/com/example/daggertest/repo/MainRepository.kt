package com.example.daggertest.repo

interface MainRepository {

    /** запись строки в память */
    fun readValue(): String

    /** извлечение строки из памяти */
    fun writeValue(value: String)
}