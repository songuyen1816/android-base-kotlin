package com.bsp.basekotlin.data.remote.api

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ErrorInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        try {
            val response = chain.proceed(request)

            val responseBody = response.peekBody(512000)
            val body = responseBody.string()
            val responseObj =
                Gson().fromJson(body, com.bsp.basekotlin.data.remote.response.Response::class.java)

            if (!response.isSuccessful) {
                throw NetworkException(errorMessage = "Server error", code = response.code)
            } else {
                if (responseObj.error) {
                    throw ApiException(responseObj.message)
                }
            }

            return response
        } catch (e: Exception) {
            var msg = ""
            when (e) {
                is ApiException, is TokenExpiredException -> {
                    throw e
                }
                else -> {
                    msg = "Network Error"
                }
            }
            throw NetworkException(errorMessage = msg, exceptionMessage = e.message)
        }
    }
}

class TokenExpiredException(msg: String) : IOException(msg)
class NetworkException(errorMessage: String, exceptionMessage: String? = null, code: Int? = null) :
    IOException(exceptionMessage)

class ApiException(msg: String) : IOException(msg)
