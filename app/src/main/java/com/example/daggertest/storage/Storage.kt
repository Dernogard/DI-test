package com.example.daggertest.storage

interface Storage {

    /** запись строки в память */
    fun readValue(): String

    /** извлечение строки из памяти */
    fun writeValue(value: String)
}