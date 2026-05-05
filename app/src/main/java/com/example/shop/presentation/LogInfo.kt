package com.example.shop.presentation

import android.util.Log

fun logInfo(tag: String, event: String, details: String) {
    Log.i("[$tag]:", "$event — $details")
}


fun logDebug(tag: String, event: String, details: String) {
    Log.d("[$tag]:", "$event — $details")
}


fun logError(tag: String, event: String, details: String) {
    Log.e("[$tag]:", "$event — $details")
}