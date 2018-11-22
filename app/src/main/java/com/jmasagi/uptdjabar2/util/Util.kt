package com.jmasagi.uptdjabar2.util

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.jmasagi.uptdjabar2.core.AppDatabase
import com.jmasagi.uptdjabar2.data.entity.ModelInspectors
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//Context
fun Context.displayToast(text: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, text, duration).show()
}

fun Context.launchActivity(to: Class<*>) {
    startActivity(Intent(this, to))
}

//String
fun String.spaceTo(change: String): String {
    this.replace(" ", change)
    return this
}

fun String.ucWords(): String {
    var space = true
    val builder = StringBuilder(this)
    val len = builder.length
    for (i in 0 until len) {
        val c = builder[i]
        if (space) {
            if (!Character.isWhitespace(c)) {
                builder.setCharAt(i, Character.toTitleCase(c))
                space = false
            }
        } else if (Character.isWhitespace(c)) {
            space = true
        } else {
            builder.setCharAt(i, Character.toLowerCase(c))
        }
    }
    return builder.toString()
}

//View
fun View.vHide() {
    this.visibility = View.GONE
}

fun View.vShow() {
    this.visibility = View.VISIBLE
}

fun Spinner.implement(context: Context, item: Int) {
    val adapter = ArrayAdapter.createFromResource(context, item, android.R.layout.simple_spinner_item)
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    this.adapter = adapter
}

fun FragmentManager.reDraw(view: View, fragment: Fragment?) {
    this.beginTransaction()
        .replace(view.id, fragment)
        .commit()
}

//JSON
fun JSONObject.toContentValues(): ContentValues {
    val cv = ContentValues()
    val temp = this.keys()
    while (temp.hasNext()) {
        val key = temp.next()
        cv.put(key, this.getString(key))
    }
    return cv
}


