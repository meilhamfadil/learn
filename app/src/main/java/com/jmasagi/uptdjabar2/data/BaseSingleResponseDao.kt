package com.jmasagi.uptdjabar2.data

import android.databinding.BaseObservable

open class BaseSingleResponseDao<T> {

    /**
     * {
     * "status" : 200,
     * "message" : "Success",
     * "result" : [Optional | list or single]
     * }
     */

    var status: Int = 200
    var message: String = ""
    private var result: T? = null

    fun data(): T {
        return result!!
    }
}