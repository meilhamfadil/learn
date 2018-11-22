package com.jmasagi.uptdjabar2.data.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.Observable
import com.google.gson.annotations.SerializedName
import com.jmasagi.uptdjabar2.data.BaseSingleResponseDao

class ModelInspectors : BaseSingleResponseDao<ModelInspectors.Data>() {

    @Entity(tableName = "inspectors")
    data class Data(
        @SerializedName("kode_pengguna") @PrimaryKey var kodePengguna: Int,
        @Bindable @ColumnInfo(name = "nama") var nama: String,
        @Bindable @ColumnInfo(name = "email") var email: String,
        @Bindable @ColumnInfo(name = "jabatan") var jabatan: String,
        @Bindable @ColumnInfo(name = "alamat") var alamat: String,
        @Bindable @ColumnInfo(name = "phone") var phone: String,
        @ColumnInfo(name = "pic") var pic: String
    )

}