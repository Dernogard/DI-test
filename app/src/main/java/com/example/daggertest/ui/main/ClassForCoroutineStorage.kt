package com.example.daggertest.ui.main

import android.util.Log
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.isActive
import java.lang.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

suspend fun Single<String>.toSuspend(disposable: CompositeDisposable) = suspendCoroutine<String> { cont ->
    this
        .doOnDispose { Log.e("CoroutineClass", "<== dispose ==>") }
        .doFinally { Log.e("CoroutineClass", "<== finally ==>") }
        .subscribe(
            {
                //if (cont.context.isActive) cont.resume("$it => Success")
                if (disposable.isDisposed.not()) cont.resume("$it => Success")
                else Log.e("CoroutineClass", "Single is disposed")
            },
            { cont.resumeWithException(Exception("")) })
    .apply { disposable.add(this) }
}