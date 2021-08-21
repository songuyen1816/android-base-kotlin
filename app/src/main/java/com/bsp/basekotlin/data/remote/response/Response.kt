package com.bsp.basekotlin.data.remote.response

import com.google.gson.annotations.SerializedName

open class Response<T>(
    @SerializedName("error") val error: Boolean = false,
    @SerializedName("code") val code: Int? = 555,
    @SerializedName("message") val message: String = "",
    @SerializedName("data") val data: T
)