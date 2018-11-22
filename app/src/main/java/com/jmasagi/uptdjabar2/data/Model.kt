package com.jmasagi.uptdjabar2.data

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.Observable

data class Model(
    @Bindable val text: String = ""
) : BaseObservable()