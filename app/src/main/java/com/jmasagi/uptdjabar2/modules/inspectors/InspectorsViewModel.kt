package com.jmasagi.uptdjabar2.modules.inspectors

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.BindingAdapter
import android.databinding.Observable
import android.widget.ImageView
import com.android.databinding.library.baseAdapters.BR
import com.jmasagi.uptdjabar2.core.Constant.DOCURI
import com.jmasagi.uptdjabar2.data.entity.ModelInspectors
import com.squareup.picasso.Picasso

data class InspectorsViewModel(
    val eInspectors: ModelInspectors.Data
) : BaseObservable() {

    var nama: String?
        @Bindable
        get() = eInspectors.nama
        set(nama) {
            eInspectors.nama = nama!!
            notifyPropertyChanged(BR.nama)
        }

    var email: String?
        @Bindable
        get() = eInspectors.email
        set(email) {
            eInspectors.email = email!!
            notifyPropertyChanged(BR.email)
        }

    var jabatan: String?
        @Bindable
        get() = eInspectors.jabatan
        set(jabatan) {
            eInspectors.jabatan = jabatan!!
            notifyPropertyChanged(BR.jabatan)
        }

    var alamat: String?
        @Bindable
        get() = eInspectors.alamat
        set(alamat) {
            eInspectors.alamat = alamat!!
            notifyPropertyChanged(BR.alamat)
        }

    var phone: String?
        @Bindable
        get() = eInspectors.phone
        set(phone) {
            eInspectors.phone = phone!!
            notifyPropertyChanged(BR.phone)
        }

    var pic: String?
        @Bindable
        get() = eInspectors.pic
        set(pic) {
            eInspectors.pic = pic!!
            notifyPropertyChanged(BR.pic)
        }

    @BindingAdapter("profilPic")
    fun loadImage(imageView: ImageView) {
        Picasso.with(imageView.context)
            .load(DOCURI + eInspectors.pic)
            .resize(256, 256)
            .centerCrop()
            .into(imageView)
    }

}