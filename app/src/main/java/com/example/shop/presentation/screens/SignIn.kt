package com.example.shop.presentation.screens

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
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shop.R
import com.example.shop.presentation.components.Back
import com.example.shop.presentation.components.CustomDialog
import com.example.shop.presentation.components.Input
import com.example.shop.presentation.components.PrimaryButton
import com.example.shop.presentation.logDebug
import com.example.shop.presentation.navigation.ForgotPassword
import com.example.shop.presentation.navigation.RegisterAccount
import com.example.shop.presentation.theme.CustomTheme

//Назначение: Создание экрана входа
//Автор: Дерябина В.Н.
//Дата: 30.04.2026
@Composable
fun SignIn(modifier: Modifier = Modifier, navController: NavController) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordShow by rememberSaveable { mutableStateOf(false) }
    var buttonEnabled by rememberSaveable { mutableStateOf(false) }
    var showDialog by rememberSaveable { mutableStateOf(false) }

    if (email.isNotEmpty() && password.isNotEmpty()) buttonEnabled = true else buttonEnabled = false
    Scaffold(
        topBar = {
            BackBar(onClick = {
                logDebug("SignIn", "Нажатие на кнопку", "Переход назад по стэку")
                navController.popBackStack()
            })
        },
        bottomBar = {
            BottomBar(onClick = {
                logDebug("SignIn", "Нажатие на кнопку", "Переход на экран RegisterAccount")
                navController.navigate(RegisterAccount)
            })
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(CustomTheme.colors.block)
        ) {
            Column(
                modifier = modifier
                    .background(CustomTheme.colors.block)
                    .padding(horizontal = 20.dp)
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Привет!",
                    style = CustomTheme.typography.HeadingRegular32,
                    color = CustomTheme.colors.text
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Заполните Свои данные",
                    style = CustomTheme.typography.BodyRegular16,
                    color = CustomTheme.colors.subTextDark
                )
                Spacer(modifier = Modifier.height(54.dp))
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
                            imageVector = ImageVector.vectorResource(if (!passwordShow) R.drawable.eye_slash else R.drawable.eye_open),
                            contentDescription = "",
                            tint = CustomTheme.colors.hint,
                            modifier = Modifier.clickable(onClick = { })
                        )
                    },
                    visualTransformation = if (passwordShow) PasswordVisualTransformation() else VisualTransformation.None,
                    text = "Пароль"
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = { navController.navigate(ForgotPassword) }),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "Востановить",
                        style = CustomTheme.typography.BodyRegular12,
                        color = CustomTheme.colors.subTextDark
                    )
                }
                Spacer(modifier = Modifier.height(41.dp))

                PrimaryButton(onClick = {
                    if (!buttonEnabled) {
                        showDialog = true
                    }
                }, text = "Войти", enabled = true)
            }
        }
        if (showDialog) {
            CustomDialog(
                onDismissRequest = { showDialog = false },
                text = "Ошибка",
                description = "Заполните все поля"
            )
        }

    }

}

@Composable
fun BottomBar(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onClick() }),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Вы впервые? ",
            style = CustomTheme.typography.BodyRegular16,
            color = CustomTheme.colors.hint
        )
        Text(
            text = "Создать пользователя",
            style = CustomTheme.typography.BodyRegular16,
            color = CustomTheme.colors.text
        )
        Spacer(modifier = Modifier.height(47.dp))
    }
}

@Composable
fun BackBar(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    color: Color = CustomTheme.colors.background
) {
    Column(
        modifier = modifier
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(23.dp))
        Back(onClick = { onClick() }, color = color)
    }
}

@Preview(device = "id:pixel_3", showSystemUi = false)
@Composable
private fun SignInPrev() {
    CustomTheme {
        //SignIn()
    }
}