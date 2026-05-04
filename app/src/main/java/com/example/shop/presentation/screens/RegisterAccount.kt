package com.example.shop.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shop.R
import com.example.shop.presentation.components.Back
import com.example.shop.presentation.components.Input
import com.example.shop.presentation.components.PrimaryButton
import com.example.shop.presentation.navigation.SignIn
import com.example.shop.presentation.theme.CustomTheme

//Назначение: Создание экрана регистрации пользователя
//Автор: Дерябина В.Н.
//Дата: 30.04.2026
@Composable
fun RegisterAccount(modifier: Modifier = Modifier, navController: NavController) {
    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    var passwordShow by rememberSaveable { mutableStateOf(false) }
    var policyClick by rememberSaveable { mutableStateOf(false) }
    var buttonEnabled by rememberSaveable { mutableStateOf(false) }

    if(policyClick && name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty())buttonEnabled=true else buttonEnabled=false

    Log.i("RegisterAccount", "Создание экрана регистрации пользователя")
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
            Row(modifier = Modifier.fillMaxWidth()) {
                Back(onClick = {})
            }
            Spacer(modifier = Modifier.height(11.dp))
            Text(
                text = "Регистрация", style = CustomTheme.typography.HeadingRegular32,
                color = CustomTheme.colors.text
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Заполните Свои данные", style = CustomTheme.typography.SubtitleRegular16,
                color = CustomTheme.colors.subTextDark
            )
            Spacer(modifier = Modifier.height(54.dp))
            Input(
                modifier = Modifier.fillMaxWidth(),
                value = name,
                onValueChange = { name = it },
                placeholder = {
                    Text(
                        text = "xxxxxxxx", style = CustomTheme.typography.BodyRegular14,
                        color = CustomTheme.colors.hint
                    )
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Input(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChange = { email = it },
                placeholder = {
                    Text(
                        text = "xyz@gmail.com", style = CustomTheme.typography.BodyRegular14,
                        color = CustomTheme.colors.hint
                    )
                },
                text = "Email"
            )
            Spacer(modifier = Modifier.height(12.dp))
            Input(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = { password = it },
                placeholder = {
                    Text(
                        text = "********", style = CustomTheme.typography.BodyRegular14,
                        color = CustomTheme.colors.hint
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(if(!passwordShow) R.drawable.eye_slash else R.drawable.eye_open),
                        contentDescription = "",
                        tint = CustomTheme.colors.hint,
                        modifier = Modifier.clickable(onClick = { })
                    )
                },
                visualTransformation = if (passwordShow) PasswordVisualTransformation() else VisualTransformation.None,
                text = "Пароль"
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .background(
                            if (!policyClick) CustomTheme.colors.background else CustomTheme.colors.accent,
                            shape = RoundedCornerShape(6.dp)
                        )
                        .size(18.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.vector),
                        contentDescription = "",
                        tint = CustomTheme.colors.text,
                        modifier = Modifier.clickable(onClick = { policyClick = !policyClick })
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Даю согласие на обработку персональных данных",
                    style = CustomTheme.typography.SubtitleRegular16,
                    color = CustomTheme.colors.hint,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.width(303.dp)
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            PrimaryButton(
                onClick = {
                    Log.d("RegisterAccount", "Нажатие кнопки для перехода на экран входа")
                    navController.navigate(SignIn)
                          },
                text = "Зарегистрироваться",
                modifier = Modifier.fillMaxWidth(),
                enabled = buttonEnabled
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Есть аккаунт?",
                    color = CustomTheme.colors.hint,
                    style = CustomTheme.typography.SubtitleRegular16
                )
                TextButton(onClick = {navController.navigate(SignIn)}) {
                    Text(
                        "Войти",
                        color = CustomTheme.colors.text,
                        style = CustomTheme.typography.SubtitleRegular16
                    )
                }
            }
            Spacer(modifier = Modifier.height(47.dp))
        }
    }
}

@Preview
@Composable
private fun RegisterAccountPrev() {
    CustomTheme {
       // RegisterAccount()
    }

}