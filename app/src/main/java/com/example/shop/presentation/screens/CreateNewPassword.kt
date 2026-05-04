package com.example.shop.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shop.R
import com.example.shop.presentation.components.CustomBox
import com.example.shop.presentation.components.CustomDialog
import com.example.shop.presentation.components.Input
import com.example.shop.presentation.components.PrimaryButton
import com.example.shop.presentation.navigation.SignIn
import com.example.shop.presentation.theme.CustomTheme

@Composable
fun CreateNewPassword(modifier: Modifier = Modifier, navController: NavController) {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordConfirm by rememberSaveable { mutableStateOf("") }
    var passwordShow by rememberSaveable { mutableStateOf(false) }
    var passwordShowConfirm by rememberSaveable { mutableStateOf(false) }

    var buttonEnabled by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        topBar = {
            BackBar(onClick = {})
        }
    ) { innerPadding ->
        CustomBox(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 20.dp),
            content = {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Задать Новый Пароль",
                    style = CustomTheme.typography.HeadingRegular32,
                    color = CustomTheme.colors.text
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Установите Новый Пароль Для Входа В Вашу Учетную Запись",
                    style = CustomTheme.typography.BodyRegular16,
                    color = CustomTheme.colors.subTextDark,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(40.dp))
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
                Spacer(modifier = Modifier.height(20.dp))
                Input(
                    modifier = Modifier.fillMaxWidth(),
                    value = passwordConfirm,
                    onValueChange = { passwordConfirm = it },
                    placeholder = {
                        Text(
                            text = "********", style = CustomTheme.typography.BodyRegular14,
                            color = CustomTheme.colors.hint
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(if (!passwordShowConfirm) R.drawable.eye_slash else R.drawable.eye_open),
                            contentDescription = "",
                            tint = CustomTheme.colors.hint,
                            modifier = Modifier.clickable(onClick = { })
                        )
                    },
                    visualTransformation = if (passwordShowConfirm) PasswordVisualTransformation() else VisualTransformation.None,
                    text = "Подтверждение пароля"
                )
                Spacer(modifier = Modifier.height(40.dp))

                PrimaryButton(onClick = {
                    if ((password.isNotEmpty() && passwordConfirm.isNotEmpty()) && password == passwordConfirm) {
                        buttonEnabled = true
                        navController.navigate(SignIn)
                    } else buttonEnabled = false

                }, text = "Сохранить", enabled = true)
                if (buttonEnabled) {
                    CustomDialog(
                        onDismissRequest = { buttonEnabled = false },
                        text = "Пароли не совпадают"
                    )
                }

            }
        )
    }
}

@Preview
@Composable
private fun CreateNewPasswordPrev() {
    CustomTheme {
        CreateNewPassword()
    }
}