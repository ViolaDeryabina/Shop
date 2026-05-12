package com.example.shop.presentation.viewModel

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

class ProfileViewModel {
    val uri by mutableStateOf<Uri?>(null)
}