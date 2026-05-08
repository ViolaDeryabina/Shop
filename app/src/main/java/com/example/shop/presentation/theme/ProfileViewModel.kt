package com.example.shop.presentation.theme

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

class ProfileViewModel {
    val uri by mutableStateOf<Uri?>(null)
}