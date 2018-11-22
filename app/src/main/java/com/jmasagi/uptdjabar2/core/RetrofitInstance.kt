package com.jmasagi.uptdjabar2.core

import com.jmasagi.uptdjabar2.core.Constant.APIURI
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


class RetrofitInstance {

    private val builder = Retrofit.Builder()
        .baseUrl(APIURI)
        .addConverterFactory(GsonConverterFactory.create())

    private val retrofit = builder.build()

    fun <S> createService(
        serviceClass: Class<S>
    ): S {
        return retrofit.create(serviceClass)
    }

}