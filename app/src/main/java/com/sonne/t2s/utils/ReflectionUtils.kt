package com.sonne.t2s.utils

import android.util.Log

object ReflectionUtils {
    fun getTag(obj: Any): String = obj::class.java.simpleName

    fun getCallerMethodName(depth: Int = 2): String =
        Throwable().stackTrace.getOrNull(depth)?.methodName ?: "Unknown"

    val Any.CLASSTAG: String get() = this::class.java.simpleName

    val Any.METHODTAG: String get() = Throwable().stackTrace.getOrNull(2)?.methodName ?: "Unknown"

    fun Any.logLifecycle() {
        Log.d(this.CLASSTAG, getCallerMethodName(2))
    }
}