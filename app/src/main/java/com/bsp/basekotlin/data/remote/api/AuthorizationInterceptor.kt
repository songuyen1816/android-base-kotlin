package com.bsp.basekotlin.data.remote.api

import com.bsp.basekotlin.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {

    companion object {
        const val HEADER_AUTHORIZATION = "Authorization"
        const val HEADER_APP_TOKEN = "app_token"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val builder = request.newBuilder()

        //TODO pass user token here

//        val user = ShareReferenceManager.getUser()
//
//        user?.let {
//            builder.addHeader(HEADER_AUTHORIZATION, "Bearer ${it.token}")
//        }

        builder.addHeader(HEADER_APP_TOKEN, BuildConfig.APP_TOKEN)

        request = builder.build()

        val response = chain.proceed(request)

        return response
    }


}