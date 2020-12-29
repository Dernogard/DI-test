package com.example.daggertest.storage

import javax.inject.Inject

/** Тут сохраняется имя на всю жизни приложения */

class MainStorage: Storage {

    private var cache: String = "000"

    override fun readValue() = cache

    override fun writeValue(value: String) {
        cache = value
    }
}