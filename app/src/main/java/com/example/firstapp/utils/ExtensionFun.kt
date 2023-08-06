package com.example.firstapp

import android.content.Context
import android.widget.Toast

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    val toast = Toast(this)
    toast.duration = duration
    toast.setText(message)
    toast.show()
}