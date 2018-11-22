package com.jmasagi.uptdjabar2.modules.home

import retrofit2.Call
import retrofit2.http.GET
import java.util.*

interface HomeDashboard {

    @GET("grafik/count")
    fun getHomeGrafik(): Call<List<HomeGrafikModel>>

}