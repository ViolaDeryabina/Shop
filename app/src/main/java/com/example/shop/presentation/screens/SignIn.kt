package com.example.shop.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shop.presentation.theme.CustomTheme

//Назначение: Создание экрана входа
//Автор: Дерябина В.Н.
//Дата: 30.04.2026
@Composable
fun SignIn(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(CustomTheme.colors.block)
    ) {
        Column(
            modifier = modifier
                .background(CustomTheme.colors.block)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}