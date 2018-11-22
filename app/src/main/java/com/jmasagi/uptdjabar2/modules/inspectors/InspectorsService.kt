package com.jmasagi.uptdjabar2.modules.inspectors


import com.jmasagi.uptdjabar2.data.entity.ModelInspectors
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface InspectorsService {

    @GET("pengawas/detail/{id}")
    fun getInspectorsDetail(
            @Path("id") inspectorsId: Int
    ): Call<ModelInspectors>

    @GET("pengawas/data")
    fun getInspectorsList(
            @Query("page") page: Int,
            @Query("offset") offset: Int
    ): Call<List<ModelInspectors>>

}