package com.jmasagi.uptdjabar2.data

class BaseListResponseDao<T> {

    /**
     *
     * {
     * "status" : 200,
     * "message" : "Success",
     * "result" : [Optional | list or single]
     *
     */

    var status: Int = 200
    lateinit var message: String
    lateinit var result: List<T>
}