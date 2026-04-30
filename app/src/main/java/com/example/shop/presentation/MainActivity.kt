package com.example.shop.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.shop.presentation.navigation.AppNavigation

//Назначение: Главная активность
//Автор: Дерябина В.Н.
//Дата: 30.04.2026
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            AppNavigation()
        }
    }
}
