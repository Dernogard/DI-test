package com.example.daggertest.storage

import javax.inject.Inject

/** Тут сохраняется число в ЖЦ экрана1 и его потомков */

class UserStorage @Inject constructor(): Storage {

    private var cache: String = "0"

    override fun readValue() = cache

    override fun writeValue(value: String) {
        cache = value
    }
}