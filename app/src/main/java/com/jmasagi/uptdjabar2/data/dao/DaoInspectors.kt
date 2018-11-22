package com.jmasagi.uptdjabar2.data.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.jmasagi.uptdjabar2.data.entity.ModelInspectors

@Dao
interface DaoInspectors {

    @Query("SELECT * FROM inspectors LIMIT (:offset),(:limit)")
    fun getData(limit: Int, offset: Int): List<ModelInspectors.Data>

    @Query("SELECT * FROM inspectors WHERE kodePengguna = (:kode_pengguna)")
    fun findById(kode_pengguna: Int): ModelInspectors.Data

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(inspectors: ModelInspectors.Data)

}