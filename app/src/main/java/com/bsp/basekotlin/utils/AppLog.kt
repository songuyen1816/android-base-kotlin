package com.bsp.basekotlin.utils

import android.util.Log

object AppLog {
    private const val DEFAULT_TAG = "Logger"
    private var withMethodName = false
    private var withLineNumber = false

    fun initLogger(method: Boolean, line: Boolean) {
        withMethodName = method
        withLineNumber = line
    }

    fun v(tag: String, msg: String, vararg args: Any?) {
        Log.v(tag, formatMessage(msg, args))
    }

    fun v(msg: String, vararg args: Any?) {
        v(tag, formatMessage(msg, args))
    }

    fun d(tag: String, msg: String, vararg args: Any?) {
        Log.d(tag, formatMessage(msg, args))
    }

    fun d(msg: String, vararg args: Any?) {
        d(tag, formatMessage(msg, args))
    }

    fun i(tag: String, msg: String, vararg args: Any?) {
        Log.i(tag, formatMessage(msg, args))
    }

    fun i(msg: String, vararg args: Any?) {
        i(tag, formatMessage(msg, args))
    }

    fun w(tag: String, msg: String, vararg args: Any?) {
        Log.w(tag, formatMessage(msg, args))
    }

    fun w(msg: String, vararg args: Any?) {
        w(tag, formatMessage(msg, args))
    }

    fun e(tag: String, msg: String, vararg args: Any?) {
        Log.e(tag, formatMessage(msg, args))
    }

    fun e(msg: String, vararg args: Any?) {
        e(tag, formatMessage(msg, args))
    }

    fun e(tag: String, t: Throwable?, msg: String, vararg args: Any?) {
        Log.e(tag, formatMessage(msg, args), t)
    }

    fun e(t: Throwable?, msg: String, vararg args: Any?) {
        e(tag, formatMessage(msg, args), t)
    }

    private val tag: String
        get() {
            val traceElement = Throwable().stackTrace[2]
            val fileName = traceElement.fileName ?: return DEFAULT_TAG
            return fileName.split("[.]").toTypedArray()[0]
        }

    private fun formatMessage(msg: String, vararg args: Any): String {
        return createLog(if (args.isEmpty()) msg else String.format(msg, args))
    }

    private fun createLog(log: String): String {
        if (withMethodName) {
            val traceElement = Throwable().stackTrace[3]
            return if (withLineNumber) {
                String.format("[%s():%s] %s", traceElement.methodName, traceElement.lineNumber, log)
            } else {
                String.format("[%s] %s", traceElement.methodName, log)
            }
        }
        return log
    }

}