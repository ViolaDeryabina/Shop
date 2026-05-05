package com.example.shop.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shop.presentation.components.CustomDialog
import com.example.shop.presentation.components.Input
import com.example.shop.presentation.components.PrimaryButton
import com.example.shop.presentation.logDebug
import com.example.shop.presentation.logInfo
import com.example.shop.presentation.navigation.Verification
import com.example.shop.presentation.theme.CustomTheme


//Назначение: Создание экрана создание пароля
//Автор: Дерябина В.Н.
//Дата: 04.05.2026
@Composable
fun ForgotPassword(modifier: Modifier = Modifier, navController: NavController) {
    var email by rememberSaveable { mutableStateOf("") }
    var showPopup by remember { mutableStateOf(false) }
    logInfo("Favorite","Создание экрана","Отрисовка экрана Смена пароля")

    Scaffold(
        topBar = {
            BackBar(onClick = {
                logDebug("ForgotPassword","Нажатие на кнопку","Переход назад по стэку")

                navController.popBackStack()
            })
        },
        containerColor = CustomTheme.colors.block
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Забыл пароль",
                style = CustomTheme.typography.HeadingRegular32,
                color = CustomTheme.colors.text
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Введите Свою Учетную Запись Для Сброса",
                style = CustomTheme.typography.BodyRegular16,
                color = CustomTheme.colors.subTextDark,
                modifier = Modifier.width(250.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(40.dp))
            Input(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChange = { email = it },
                placeholder = {
                    Text(
                        text = "xyz@gmail.com", style = CustomTheme.typography.BodyRegular14,
                        color = Color(0xFF6A6A6A)
                    )
                },
            )
            Spacer(modifier = Modifier.height(40.dp))
            PrimaryButton(onClick = {
                showPopup = true
            }, text = "Отправить", enabled = true)
        }
        if (showPopup) {
            CustomDialog(
                onDismissRequest = {
                    showPopup = false
                    logDebug("ForgotPassword","Нажатие на кнопку","Переход на экран Verification")

                    navController.navigate(Verification)
                },
                popup = true,
                text = "Ошибка",
                description = "Пароли не совпадают"
            )
        }

    }
}


@Preview
@Composable
private fun ForgotPasswordPrev() {
    CustomTheme {
        //ForgotPassword()
    }
}